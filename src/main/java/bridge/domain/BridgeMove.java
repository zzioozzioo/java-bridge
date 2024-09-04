package bridge.domain;

public class BridgeMove {

    private final Direction direction;
    private final int index;

    public BridgeMove(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
    }

    public String getDirection() {
        return direction.getDirection();
    }

    public int getIndex() {
        return index;
    }
}
