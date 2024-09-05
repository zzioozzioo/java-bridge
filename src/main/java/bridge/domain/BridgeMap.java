package bridge.domain;

import bridge.exception.InvalidMovingException;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<String> upStatus;
    private final List<String> downStatus;

    public BridgeMap() {
        this.upStatus = new ArrayList<>();
        this.downStatus = new ArrayList<>();
    }

    public List<String> getUpStatus() {
        return upStatus;
    }

    public List<String> getDownStatus() {
        return downStatus;
    }

    public void addMap(String direction, String status) {
        if (upDirection(direction, status)) return;
        if (downDirection(direction, status)) return;

        throw new InvalidMovingException();
    }

    public boolean upDirection(String direction, String status) {
        if (direction.equals(Direction.UP.getDirection())) {
            upStatus.add(status);
            downStatus.add(" ");
            return true;
        }
        return false;
    }

    public boolean downDirection(String direction, String status) {
        if (direction.equals(Direction.DOWN.getDirection())) {
            downStatus.add(status);
            upStatus.add(" ");
            return true;
        }
        return false;
    }

    public boolean containFail(BridgeMap bridgeMap) {
        boolean up = bridgeMap.upStatus.contains(Status.IMPOSSIBLE.getStatus());
        boolean down = bridgeMap.downStatus.contains(Status.IMPOSSIBLE.getStatus());

        return up || down;
    }

    public void resetMap() {
        this.upStatus.clear();
        this.downStatus.clear();
    }
}
