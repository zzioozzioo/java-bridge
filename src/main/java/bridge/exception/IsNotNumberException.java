package bridge.exception;

public class IsNotNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닙니다.";

    public IsNotNumberException() {
        super(ERROR_MESSAGE);
    }
}
