package main.command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface Command {
    void execute();
}

class SendEmailCommand implements Command {
    private final String recipient;
    private final String content;

    public SendEmailCommand(String recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    public void execute() {
        System.out.println("이메일 전송 대상: " + recipient);
        System.out.println("내용: " + content);
    }
}

class TaskQueue {
    private final BlockingQueue<Command> queue = new LinkedBlockingQueue<>();
    private final Thread worker;

    TaskQueue() {
        worker = new Thread(() -> {
            while (true) {
                try {
                    Command task = queue.take();
                    task.execute();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        worker.start();
    }

    public void addTask(Command command) {
        queue.add(command);
    }

    public void shutdown() {
        worker.interrupt();
    }
}

class CommandExample {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();

        taskQueue.addTask(new SendEmailCommand("jinwoo@example.com", "서비스에 가입 메일"));
        taskQueue.addTask(new SendEmailCommand("dev@example.com", "결제 메일"));
        taskQueue.addTask(new SendEmailCommand("team@example.com", "배송 시작 메일"));

        Thread.sleep(1000);
        taskQueue.shutdown();
    }
}
