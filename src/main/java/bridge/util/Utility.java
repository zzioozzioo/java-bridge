package bridge.util;

import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;

import java.util.Arrays;

public class Utility {

    private static <T> T match(T[] values, String matchType) {
        return Arrays.stream(values)
                .filter(v -> v.toString().equals(matchType))
                .findFirst()
                .orElseThrow(InvalidGameCommandException::new);
    }

    public static Command matchCommand(String command) {
        return match(Command.values(), command);
    }

    public static Direction matchDirection(String direction) {
        return match(Direction.values(), direction);
    }
}



