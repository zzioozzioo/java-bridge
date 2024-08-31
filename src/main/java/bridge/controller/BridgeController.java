package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {

    }

    /**
     * 다리 건너는 동작
     */
    public void passBridge() {
        int bridgeSize = inputView.readBridgeSize();
        String moving;
        List<String> bridge = getNewBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap bridgeMap;

        for (int i = 0; i < bridgeSize; i++) {

            moving = inputView.readMoving();
            validateMoving(moving);

            bridgeMap = bridgeGame.move(moving, i);
            outputView.printMap(bridgeMap);
        }
    }

    private static void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNewBridge(int count) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(count);
    }
}
