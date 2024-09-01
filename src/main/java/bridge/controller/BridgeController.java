package bridge.controller;

import bridge.constant.ConstMessage;
import bridge.constant.ConstNumber;
import bridge.constant.ErrorMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeService bridgeService;

    final String errorMsg = "[ERROR]";

    public void run() {
        startGame();
        playBridgeGame(makeNewBridge());
    }

    // TODO: 사용자 입력값에 대한 유효성 검증은 어디서?

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
                return bridgeService.getNewBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidSize(int bridgeSize) {
        if (bridgeSize < ConstNumber.MIN_SIZE.getSize() || bridgeSize > ConstNumber.MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getValue());
        }
    }

    /**
     * 다리 건너기 시작
     */
    public void playBridgeGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeService = new BridgeService(bridgeGame);
        BridgeMap bridgeMap;

        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap = passOneKan(i);
            outputView.printMap(bridgeMap);
            if (whenFail(bridgeMap, bridgeGame)) {
                return;
            }
        }

        printEndGame(bridgeGame, true);
    }

    public BridgeMap passOneKan(int index) {
        String moving = readValidMoving();

        BridgeMap bridgeMap = bridgeService.processMove(moving, index);
        outputView.printMap(bridgeMap);

        return bridgeMap;
    }

    /**
     * 이동할 칸 입력 유효성 검사
     */
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
        if (!moving.equals(ConstMessage.UP.getValue()) && !moving.equals(ConstMessage.DOWN.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING.getValue());
        }
    }

    /**
     * 게임에 실패한 경우
     */
    private boolean whenFail(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        if (bridgeService.isFail(bridgeMap)) {

            if (restartGame()) {
                bridgeService.restart();
                playBridgeGame(bridgeGame.getBridge());
            }

            printEndGame(bridgeGame, false);
            return true;
        }
        return false;
    }


    /**
     * 게임 재시작
     */
    public boolean restartGame() {
        String gameCommand = readValidGameCommand();

        if (gameCommand.equals(ConstMessage.RESTART.getValue())) return true;
        if (gameCommand.equals(ConstMessage.QUIT.getValue())) return false;

        // TODO: 이부분도 다시 입력받아야 하나? 이미 R/Q 유효성 검사 마쳤는데?
        throw new IllegalArgumentException(errorMsg);
    }

    /**
     * 게임 재시작 여부 입력 유효성 검사
     */
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
        if (!gameCommand.equals(ConstMessage.RESTART.getValue()) && !gameCommand.equals(ConstMessage.QUIT.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.getValue());
        }
    }

    /**
     * 게임 종료 출력
     */
    private void printEndGame(BridgeGame bridgeGame, boolean flag) {
        String result = ConstMessage.SUCCESS.getValue();
        if (!flag) {
            result = ConstMessage.FAIL.getValue();
        }

        outputView.printResult(); // TODO: 이거 완성하기
        outputView.printIsSuccess(result);
        outputView.printTryCount(bridgeGame);
    }
}
