package bridge.domain;

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

    public void addMap(DirectionOperation operation, String status) {
        operation.update(this, status);
    }

    public void addUpStatus(String status) {
        upStatus.add(status);
    }

    public void addEmptyToUpStatus() {
        upStatus.add(" ");
    }

    public void addDownStatus(String status) {
        downStatus.add(status);
    }

    public void addEmptyToDownStatus() {
        downStatus.add(" ");
    }

    public boolean containFail(BridgeMap bridgeMap) {
        boolean up = bridgeMap.upStatus.contains(Status.IMPOSSIBLE.getStatus());
        boolean down = bridgeMap.downStatus.contains(Status.IMPOSSIBLE.getStatus());

        return up || down;
    }

    public void resetMap() {
        upStatus.clear();
        downStatus.clear();
    }
}
