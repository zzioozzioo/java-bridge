package bridge.util;

import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.domain.Status;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;

import static bridge.domain.Status.IMPOSSIBLE;
import static bridge.domain.Status.POSSIBLE;


public class Utility {

    public static Status matchStatus(String direction, String target) {

        // TODO: if문 제거
        if (direction.equals(target)) {
            return POSSIBLE;
        }
        return IMPOSSIBLE;
    }

    public static Command matchCommand(String playerCommand) {
        for (Command cmd : Command.values()) {
            if (cmd.getCommand().equals(playerCommand)) {
                return cmd;
            }
        }
        throw new InvalidGameCommandException();
    }

    public static Direction matchDirection(String direction) {
        for (Direction d : Direction.values()) {
            if (d.getDirection().equals(direction)) {
                return d;
            }
        }
        throw new InvalidMovingException();
    }
}

