package bridge.domain;

public class UpDirectionOperation implements DirectionOperation {

    @Override
    public void update(BridgeMap bridgeMap, String status) {
        bridgeMap.addUpStatus(status);
        bridgeMap.addEmptyToDownStatus();
    }
}
