package bridge.domain;

public class BridgeMove {

    private final String moving;
    private final int index;

    public BridgeMove(String move, int index) {
        this.moving = move;
        this.index = index;
    }

    public String getMoving() {
        return moving;
    }

    public int getIndex() {
        return index;
    }
}
