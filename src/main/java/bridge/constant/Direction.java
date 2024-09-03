package bridge.constant;

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
}
