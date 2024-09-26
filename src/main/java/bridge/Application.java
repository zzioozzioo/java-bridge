package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.service.BridgeService;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<String> bridge = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeService bridgeService = new BridgeService(bridgeGame);
        BridgeController bridgeController = new BridgeController(bridgeService);

        bridgeController.run();
    }
}
