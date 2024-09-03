package bridge.exception;

import bridge.constant.ConstMessage;

public class InvalidGameCommandException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 게임 재시도 여부는 "
            + ConstMessage.RESTART.getValue() + " 또는 "
            + ConstMessage.QUIT.getValue() + "여야 합니다";

    public InvalidGameCommandException() {
        super(ERROR_MESSAGE);
    }
}
