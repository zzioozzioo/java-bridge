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
}
