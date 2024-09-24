package bridge.domain;

import java.util.List;

import static bridge.util.Utility.matchDirection;
import static bridge.util.Utility.matchStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int tryCount = 1;
    List<String> bridge;
    BridgeMap bridgeMap;

    public int getTryCount() {
        return tryCount;
    }

    public void addCount() {
        this.tryCount++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setNewBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public BridgeMap getBridgeMap() {
        if (this.bridgeMap == null) {
            this.bridgeMap = new BridgeMap();
        }
        return this.bridgeMap;
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(BridgeMove bridgeMove, BridgeGame bridgeGame) {
        String direction = bridgeMove.getDirection();
        int index = bridgeMove.getIndex();
        List<String> bridge = bridgeGame.getBridge();
        BridgeMap bridgeMap = bridgeGame.getBridgeMap();
        Status status = matchStatus(direction, bridge.get(index));
        DirectionOperation operation = matchDirection(direction).getOperation();

        bridgeMap.addMap(operation, status.getStatus());
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
