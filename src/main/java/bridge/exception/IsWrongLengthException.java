package bridge.exception;

public class IsWrongLengthException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 문자 하나만 입력해야 합니다.";

    public IsWrongLengthException() {
        super(ERROR_MESSAGE);
    }
}
