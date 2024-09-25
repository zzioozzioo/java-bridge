package bridge.util;

import bridge.domain.Status;

import java.util.Arrays;

public class Utility {

    public static <T> T match(T[] values, String matchType, RuntimeException e) {
        return Arrays.stream(values)
                .filter(v -> v.toString().equals(matchType))
                .findFirst()
                .orElseThrow(() -> e);
    }

    public static Status isEqualStatus(String direction, String target) {
        if (direction.equals(target)) {
            return Status.POSSIBLE;
        }
        return Status.IMPOSSIBLE;
    }

}



