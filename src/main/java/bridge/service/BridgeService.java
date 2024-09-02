package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ConstMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;

import java.util.List;

public class BridgeService {

    private final BridgeGame bridgeGame;
    public BridgeService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    public List<String> getNewBridge(int count) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(count);
    }

    public BridgeMap processMove(String moving, int index) {
        return bridgeGame.move(moving, index);
    }

    public boolean isFail(BridgeMap bridgeMap) {
        return bridgeMap.getAllMap().containsValue(ConstMessage.IMPOSSIBLE.getValue());
    }

    public void restart() {
        bridgeGame.retry();
    }
}
