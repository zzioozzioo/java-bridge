package bridge.domain;

import java.util.HashMap;

public class BridgeMap {

    private final HashMap<String, String> bridgeMap;

    public BridgeMap(HashMap<String, String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public void addMap(String moving, String possible) {
        bridgeMap.put(moving, possible);
    }

    public HashMap<String, String> getAllMap() {
        return this.bridgeMap;
    }

    public void resetMap() {
        this.bridgeMap.clear();
    }
}
