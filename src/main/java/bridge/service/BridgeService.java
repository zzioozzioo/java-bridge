package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Status;
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

    public BridgeMap processMove(BridgeMove bridgeMove, BridgeGame bridgeGame) {
        return bridgeGame.move(bridgeMove, bridgeGame);
    }

    public boolean isFail(BridgeMap bridgeMap) {
        return bridgeMap.getAllMap().containsValue(Status.IMPOSSIBLE.getStatus());
    }

    public void restart() {
        bridgeGame.retry();
    }
}
