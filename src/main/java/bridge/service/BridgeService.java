package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeMove;

public class BridgeService {

    private final BridgeGame bridgeGame;
    public BridgeService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    public void getNewBridge(int count) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame.setNewBridge(bridgeMaker.makeBridge(count));
    }

    public BridgeMap processMove(BridgeMove bridgeMove) {
        return bridgeGame.move(bridgeMove);
    }

    public boolean isFail(BridgeMap bridgeMap) {
        return bridgeMap.containFail(bridgeMap);
    }

    public void restart() {
        bridgeGame.retry();
    }
}
