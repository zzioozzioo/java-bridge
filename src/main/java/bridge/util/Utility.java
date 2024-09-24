package bridge.util;

import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;


public class Utility {

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

