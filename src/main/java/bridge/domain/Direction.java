package bridge.domain;

import bridge.exception.InvalidMovingException;

public enum Direction {

    UP("U"),
    DOWN("D");

    final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
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
