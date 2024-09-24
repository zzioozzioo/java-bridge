package bridge.domain;

import bridge.exception.InvalidMovingException;

public enum Direction {

    UP("U", new UpDirectionOperation()),
    DOWN("D", new DownDirectionOperation());

    private final String direction;
    private final DirectionOperation operation;

    Direction(String direction, DirectionOperation operation) {
        this.direction = direction;
        this.operation = operation;
    }

    public String getDirection() {
        return direction;
    }

    public DirectionOperation getOperation() {
        return operation;
    }
}
