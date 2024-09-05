package bridge.view;

import bridge.constant.ConstMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.domain.BridgePrinter;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 문구 출력
     */
    public void printStartGame() {
        System.out.println(ConstMessage.START_GAME.getValue());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMap bridgeMap) {
        List<String> upStatus = bridgeMap.getUpStatus();
        List<String> downStatus = bridgeMap.getDownStatus();
        BridgePrinter bridgePrinter = new BridgePrinter();

        bridgePrinter.addAllBridge(upStatus, downStatus);

        System.out.println(bridgePrinter.print());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeMap bridgeMap) {
        System.out.println(ConstMessage.GAME_RESULT.getValue());
        printMap(bridgeMap);
    }

    /**
     * 게임 성공 여부 출력
     */
    public void printIsSuccess(String isSuccess) {
        System.out.println(ConstMessage.IS_SUCCESS.getValue() + isSuccess);
    }

    /**
     * 시도 횟수 출력
     */
    public void printTryCount(BridgeGame bridgeGame) {
        System.out.println(ConstMessage.TRY_COUNT.getValue() + (bridgeGame.getTryCount()));
    }

}
