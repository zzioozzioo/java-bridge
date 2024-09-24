package bridge.util;

import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;

import java.util.Arrays;

public class Utility {

    private static <T> T match(T[] values, String matchType, RuntimeException e) {
        return Arrays.stream(values)
                .filter(v -> v.toString().equals(matchType))
                .findFirst()
                .orElseThrow(() -> e);
    }

    public static Command matchCommand(String command) {
        return match(Command.values(), command, new InvalidGameCommandException());
    }

    public static Direction matchDirection(String direction) {
        return match(Direction.values(), direction, new InvalidMovingException());
    }
}



