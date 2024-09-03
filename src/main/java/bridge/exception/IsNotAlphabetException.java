package bridge.exception;

public class IsNotAlphabetException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 알파벳을 입력해야 합니다.";

    public IsNotAlphabetException() {
        super(ERROR_MESSAGE);
    }
}
