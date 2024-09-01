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

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

        startGame();
        playBridgeGame(makeNewBridge());

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
    public void playBridgeGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap bridgeMap;

        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap = passOneKan(bridgeGame, i);
            whenFail(bridgeMap, bridgeGame);
        }

        printEndGame(bridgeGame, true);
    }

    private void whenFail(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        if (isFail(bridgeMap)) {

            if (restartGame()) {
                bridgeGame.retry();
                playBridgeGame(bridgeGame.getBridge());
            }

            printEndGame(bridgeGame, false);
        }
    }

    private boolean isFail(BridgeMap bridgeMap) {
        return bridgeMap.getAllMap().containsValue("X");
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
    public boolean restartGame() {
        String gameCommand = inputView.readGameCommand();
        isValidGameCommand(gameCommand);

        if (gameCommand.equals("R")) return true;
        if (gameCommand.equals("Q")) return false;

        throw new IllegalArgumentException(); // R, Q 모두 아닌 경우
    }

    public void isValidGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

    private void printEndGame(BridgeGame bridgeGame, boolean flag) {
        String result = "성공";
        if (!flag) {
            result = "실패";
        }

        outputView.printResult(); // TODO: 이거 완성하기
        outputView.printIsSuccess(result);
        outputView.printTryCount(bridgeGame);
    }
}
