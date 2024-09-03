package bridge.exception;

import bridge.constant.ConstMessage;
import bridge.constant.Direction;

public class InvalidMovingException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 이동할 칸은 "
            + Direction.UP.getDirection() + " 또는 "
            + Direction.DOWN.getDirection() + "여야 합니다.";

    public InvalidMovingException() {
        super(ERROR_MESSAGE);
    }
}
