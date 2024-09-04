package bridge.exception;

import bridge.domain.Command;

public class InvalidGameCommandException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 게임 재시도 여부는 "
            + Command.RESTART.getCommand() + " 또는 "
            + Command.QUIT.getCommand() + "여야 합니다";

    public InvalidGameCommandException() {
        super(ERROR_MESSAGE);
    }
}
