package bridge.controller;

import bridge.domain.*;
import bridge.exception.InvalidBridgeSizeException;
import bridge.exception.InvalidGameCommandException;
import bridge.exception.InvalidMovingException;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.Command.matchCommand;
import static bridge.domain.Direction.matchDirection;
import static bridge.domain.Result.FAIL;
import static bridge.domain.Result.SUCCESS;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }


    public void run() {
        outputView.printStartGame();
        makeNewBridge();
        playBridgeGame();
    }

    /**
     * 새로운 다리 생성
     */
    public void makeNewBridge() {
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
    public void playBridgeGame() {
        BridgeGame bridgeGame = bridgeService.getBridgeGame();
        List<String> bridge = bridgeGame.getBridge();

        for (int i = 0; i < bridge.size(); i++) {
            if (passOneKan(i)) return;
        }
        printEndGame(SUCCESS);
    }

    public boolean passOneKan(int index) {
        Direction direction = matchDirection(readValidMoving());

        BridgeMove bridgeMove = new BridgeMove(direction, index);
        BridgeMap bridgeMap = bridgeService.processMove(bridgeMove);

        outputView.printMap(bridgeMap);
        return handleFailure(bridgeMap);
    }

    public boolean handleFailure(BridgeMap bridgeMap) {
        if (!bridgeService.isFail(bridgeMap)) {
            return false;
        }
        if (restartGame()) {
            bridgeService.restart();
            playBridgeGame();
            return true;
        }
        printEndGame(FAIL);
        return true;
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
    public void printEndGame(Result result) {
        BridgeGame bridgeGame = bridgeService.getBridgeGame();

        outputView.printResult(bridgeGame.getBridgeMap());
        outputView.printIsSuccess(result);
        outputView.printTryCount(bridgeGame);
    }
}
