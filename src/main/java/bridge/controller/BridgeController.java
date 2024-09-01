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

    // TODO: 서비스 계층과 역할 분담 -> 어떻게?

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
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                isValidSize(bridgeSize);
                return getNewBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3과 20 사이여야 합니다.");
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
            return;
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
        BridgeMap bridgeMap;
        String moving = readValidMoving();

        bridgeMap = bridgeGame.move(moving, i);
        outputView.printMap(bridgeMap);

        return bridgeMap;
    }

    private String readValidMoving() {
        String moving;
        while (true) {
            try {
                moving = inputView.readMoving();
                isValidMoving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
        }
    }


    /**
     * 게임 재시작
     *
     */
    public boolean restartGame() {
        String gameCommand = readValidGameCommand();

        if (gameCommand.equals("R")) return true;
        if (gameCommand.equals("Q")) return false;

        throw new IllegalArgumentException(); // R, Q 모두 아닌 경우
    }

    private String readValidGameCommand() {
        while (true) {
            try {
                String gameCommand = inputView.readGameCommand();
                isValidGameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R 또는 Q여야 합니다");
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
