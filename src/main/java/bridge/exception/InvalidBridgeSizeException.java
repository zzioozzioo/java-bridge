package bridge.exception;

import bridge.constant.ConstNumber;

public class InvalidBridgeSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 다리의 길이는 "
            + ConstNumber.MIN_SIZE.getSize() + "과 "
            + ConstNumber.MAX_SIZE.getSize() + " 사이여야 합니다.";

    public InvalidBridgeSizeException() {
        super(ERROR_MESSAGE);
    }
}
