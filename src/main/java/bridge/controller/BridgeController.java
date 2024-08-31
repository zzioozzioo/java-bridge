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

        startGame();
        List<String> bridge = makeNewBridge();

        passBridge(bridge);

    }

    /**
     * 게임 시작
     */
    public void startGame() {
        outputView.printStartGame();
    }

    /**
     * 새로운 다리 생성
     */
    public List<String> makeNewBridge() {
        int bridgeSize = inputView.readBridgeSize();
        isValidSize(bridgeSize);
        return getNewBridge(bridgeSize);
    }

    public void isValidSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNewBridge(int count) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(count);
    }

    /**
     * 다리 건너는 동작
     *
     */
    public void passBridge(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap bridgeMap;

        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap = passOneKan(bridgeGame, i);
            if (checkFail(bridge, bridgeMap, bridgeGame))
                return;
        }
        printEndGame(bridgeGame);
    }

    private boolean checkFail(List<String> bridge, BridgeMap bridgeMap, BridgeGame bridgeGame) {
        if (bridgeMap.getAllMap().containsValue("X")) {
            if (restartGame(bridge, bridgeGame)) {
                return true;
            }
        }
        return false;
    }

    public BridgeMap passOneKan(BridgeGame bridgeGame, int i) {
        String moving;
        BridgeMap bridgeMap;

        moving = inputView.readMoving();
        isValidMoving(moving);

        bridgeMap = bridgeGame.move(moving, i);
        outputView.printMap(bridgeMap);

        return bridgeMap;
    }

    public void isValidMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 게임 재시작
     *
     */
    public boolean restartGame(List<String> bridge, BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        isValidGameCommand(gameCommand);
        if (gameCommand.equals("R")) {
            bridgeGame.addCount();
            passBridge(bridge);
        }
        if (gameCommand.equals("Q")) {
            // 게임 최종 결과 출력 및 종료
            printEndGame(bridgeGame);
            return false;
        }

        throw new IllegalArgumentException(); // R, Q 모두 아닌 경우
    }

    public void isValidGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

    private void printEndGame(BridgeGame bridgeGame) {
        outputView.printResult(); // TODO: 이거 완성하기
        outputView.printIsSuccess("실패");
        outputView.printTryCount(bridgeGame);
    }
}
