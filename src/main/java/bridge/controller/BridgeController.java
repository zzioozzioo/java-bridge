package bridge.controller;

import bridge.domain.*;
import bridge.exception.InvalidBridgeSizeException;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.Result.FAIL;
import static bridge.domain.Result.SUCCESS;
import static bridge.util.Utility.*;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeService bridgeService;


    public void run() {
        List<String> bridge = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeService = new BridgeService(bridgeGame);

        startGame();
        makeNewBridge(bridgeService);
        playBridgeGame(bridgeService);
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
    public void makeNewBridge(BridgeService bridgeService) {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                isValidSize(bridgeSize);
                bridgeService.getNewBridge(bridgeSize);
                return;
            } catch (InvalidBridgeSizeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidSize(int bridgeSize) {
        Range.validateSize(bridgeSize);
    }

    /**
     * 다리 건너기 시작
     */
    public void playBridgeGame(BridgeService bridgeService) {
        BridgeMap bridgeMap;
        List<String> bridge = bridgeService.getBridgeGame().getBridge();

        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap = passOneKan(i, bridgeService.getBridgeGame());
            if (whenFail(bridgeMap, bridgeService.getBridgeGame())) return;
        }

        printEndGame(bridgeService.getBridgeGame(), SUCCESS);
    }

    public BridgeMap passOneKan(int index, BridgeGame bridgeGame) {
        String strDirection = readValidMoving();
        Direction direction = matchDirection(strDirection);

        BridgeMove bridgeMove = new BridgeMove(direction, index);
        BridgeMap bridgeMap = bridgeService.processMove(bridgeMove, bridgeGame);

        outputView.printMap(bridgeMap);

        return bridgeMap;
    }

    /**
     * 이동할 칸 입력 유효성 검사
     */
    public String readValidMoving() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                isValidMoving(moving);
                return moving;
            } catch (InvalidMovingException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isValidMoving(String moving) {
        matchDirection(moving);
    }

    /**
     * 게임에 실패한 경우
     */
    // TODO: 도메인 로직으로 분리,, 다시 수정해보기
    public boolean whenFail(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        if (!bridgeService.isFail(bridgeMap)) {
            return false;
        }
        if (restartGame()) {
            restartAndPlayAgain();
            return true;
        }
        endGame(bridgeGame);
        return true;
    }

    public void restartAndPlayAgain() {
        bridgeService.restart();
        playBridgeGame(bridgeService);
    }

    public void endGame(BridgeGame bridgeGame) {
        printEndGame(bridgeGame, FAIL);
    }


    /**
     * 게임 재시작
     */
    public boolean restartGame() {
        Command command = readValidGameCommand();
        return command.isEqualToRestartCommand(Command.RESTART.getCommand());
    }

    /**
     * 게임 재시작 여부 입력 유효성 검사
     */
    public Command readValidGameCommand() {
        while (true) {
            try {
                return isValidGameCommand(inputView.readGameCommand());
            } catch (InvalidGameCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Command isValidGameCommand(String gameCommand) {
        return matchCommand(gameCommand);
    }

    /**
     * 게임 종료 출력
     */
    public void printEndGame(BridgeGame bridgeGame, Result result) {

        String flag = result.getResult();

        outputView.printResult(bridgeGame.getBridgeMap());
        outputView.printIsSuccess(flag);
        outputView.printTryCount(bridgeGame);
    }
}
