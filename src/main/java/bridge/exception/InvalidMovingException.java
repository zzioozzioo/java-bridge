package bridge.exception;

import bridge.constant.ConstMessage;

public class InvalidMovingException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 이동할 칸은 "
            + ConstMessage.UP.getValue() + " 또는 "
            + ConstMessage.DOWN.getValue() + "여야 합니다.";

    public InvalidMovingException() {
        super(ERROR_MESSAGE);
    }
}
