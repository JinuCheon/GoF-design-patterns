package main.singleton;

/**
 * 브라우저를 통한 캡처를 제공하는 서비스
 */
public class CaptureService {

    // singleton 브라우저
    private static Browser browser;

    /**
     * 브라우저를 실행하는 메서드.
     */
    private void launchBrowser() {
        if (null == browser) throw new IllegalStateException("이미 브라우저가 실행중입니다.");
        browser = new Browser();
    }

    /**
     * 현재 페이지를 캡처.
     */
    public String captureCurrentPage() {
        if (isBrowserRunning()) launchBrowser();
        return browser.capture();
    }

    /**
     * @param url 이동할 페이지 URL
     */
    public void movePageTo(String url) {
        if (isBrowserRunning()) launchBrowser();
        System.out.println("Moved to " + url);
    }

    private static class Browser {
        public String capture() {
            return "Captured";
        }
    }

    private boolean isBrowserRunning() {
        return null == browser;
    }
}
