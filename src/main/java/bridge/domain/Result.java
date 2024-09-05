package bridge.domain;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    final String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public static String matchResult(boolean flag) {

        if (!flag) {
            return String.valueOf(FAIL.getResult());
        }
        return String.valueOf(SUCCESS.getResult());
    }
}
