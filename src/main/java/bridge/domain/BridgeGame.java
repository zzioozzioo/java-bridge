package bridge.domain;

import bridge.constant.ConstMessage;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int tryCount;
    List<String> bridge;
    BridgeMap bridgeMap;

    public void addCount() {
        this.tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(String moving, int index) {
        if (moving.equals(bridge.get(index))) {
            bridgeMap.addMap(moving, ConstMessage.POSSIBLE.getValue());
            return bridgeMap;
        }
        bridgeMap.addMap(moving, ConstMessage.IMPOSSIBLE.getValue());
        return bridgeMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        addCount();
        bridgeMap.resetMap();
    }
}
