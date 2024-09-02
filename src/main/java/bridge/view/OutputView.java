package bridge.view;

import bridge.constant.ConstMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;

import java.util.HashMap;
import java.util.Map;

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
    public void printMap(BridgeMap map) {
        HashMap<String, String> bridgeMap = map.getAllMap();
        // TODO: 출력 형식대로 출력하는 건 나중에,,
        // TODO: 띄어쓰기, 다리 칸 구분은 어떻게?

        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();

        for (Map.Entry<String, String> entry : bridgeMap.entrySet()) {
            if (entry.getKey().equals(ConstMessage.UP.getValue())) {
                up.append(entry.getValue());
                down.append(" ");
            }
            if (entry.getKey().equals(ConstMessage.DOWN.getValue())) {
                down.append(entry.getValue());
                up.append(" ");
            }

        }

        System.out.println("[" + up + "]");
        System.out.println("[" + down + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
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
        System.out.println(ConstMessage.TRY_COUNT.getValue() + (bridgeGame.getTryCount() + 1));
    }

    /**
     * 에러 문구 출력?
     */
    public void printErrorMessage() {
    }
}
