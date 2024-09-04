package bridge.exception;

import bridge.domain.Range;

public class InvalidBridgeSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 다리의 길이는 "
            + Range.MIN_SIZE.getSize() + "과 "
            + Range.MAX_SIZE.getSize() + " 사이여야 합니다.";

    public InvalidBridgeSizeException() {
        super(ERROR_MESSAGE);
    }
}
