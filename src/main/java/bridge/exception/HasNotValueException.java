package bridge.exception;

public class HasNotValueException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력값이 비어있습니다.";

    public HasNotValueException() {
        super(ERROR_MESSAGE);
    }
}
