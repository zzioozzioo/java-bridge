package bridge.domain;

import java.util.HashMap;

public class BridgeMap {

    private final HashMap<String, String> bridgeMap;

    public BridgeMap(HashMap<String, String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public BridgeMap addMap(String move, String possible) {
        bridgeMap.put(move, possible);
        return this;
    }
}
