package bridge.domain;

public class DownDirectionOperation implements DirectionOperation {

    @Override
    public void update(BridgeMap bridgeMap, String status) {
        bridgeMap.addEmptyToUpStatus();
        bridgeMap.addDownStatus(status);
    }
}
