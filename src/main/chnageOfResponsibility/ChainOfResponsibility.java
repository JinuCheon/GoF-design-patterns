package main.chnageOfResponsibility;

enum AlarmType {
    TASK_COMPLETE,
    MESSENGER,
    GENERAL
}

// 알림 메시지 클래스
class Alarm {
    private final String message;
    private final AlarmType type;

    public Alarm(AlarmType type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public AlarmType getType() {
        return type;
    }
}

// 알람 핸들러 추상 클래스
abstract class AlarmHandler {
    private AlarmHandler next;

    public AlarmHandler setNext(AlarmHandler next) {
        this.next = next;
        return next;
    }

    public final void handle(Alarm alarm) {
        if (!process(alarm) && null != next) {
            next.handle(alarm);
        }
    }

    protected abstract boolean process(Alarm alarm);
}

// 작업 완료 알람 처리 핸들러
class TaskCompleteAlarmHandler extends AlarmHandler {
    @Override
    protected boolean process(Alarm alarm) {
        if (AlarmType.TASK_COMPLETE == alarm.getType()) {
            System.out.println("작업 완료 알람 처리: " + alarm.getMessage());
            return true;
        }
        return false;
    }
}

// 메신저 알람 처리 핸들러
class MessengerAlarmHandler extends AlarmHandler {
    @Override
    protected boolean process(Alarm alarm) {
        if (AlarmType.MESSENGER == alarm.getType()) {
            System.out.println("메신저 알람 처리: " + alarm.getMessage());
            return true;
        }
        return false;
    }
}

// 일반 알람 처리 핸들러
class GeneralAlarmHandler extends AlarmHandler {
    @Override
    protected boolean process(Alarm alarm) {
        System.out.println("일반 알람 처리: " + alarm.getMessage());
        return true;
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        AlarmHandler taskCompleteHandler = new TaskCompleteAlarmHandler();
        AlarmHandler messengerHandler = new MessengerAlarmHandler();
        AlarmHandler generalHandler = new GeneralAlarmHandler();

        // 핸들러 체인 설정
        taskCompleteHandler.setNext(messengerHandler).setNext(generalHandler);

        // 테스트 알람
        taskCompleteHandler.handle(new Alarm(AlarmType.TASK_COMPLETE, "일일 리포트 작성 완료"));
        taskCompleteHandler.handle(new Alarm(AlarmType.MESSENGER, "채팅방 새 메시지 도착"));
        taskCompleteHandler.handle(new Alarm(AlarmType.GENERAL, "기타 알림 메시지"));
    }
}
