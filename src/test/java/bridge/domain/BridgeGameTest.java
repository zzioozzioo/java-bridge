package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {

    @DisplayName("칸 이동 테스트")
    @Test
    void MoveTest() {
        //given
        // 다리 생성
        List<String> bridge = List.of("D", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // 플레이어의 첫 번째 이동
        Direction firstDirection = Direction.DOWN;
        int firstIndex = 0;
        BridgeMove firstMove = new BridgeMove(firstDirection, firstIndex);

        // 플레이어의 두 번째 이동
        Direction secondDirection = Direction.UP;
        int secondIndex = 1;
        BridgeMove secondMove = new BridgeMove(secondDirection, secondIndex);

        //when
        BridgeMap bridgeMap;
        bridgeGame.move(firstMove, bridgeGame);
        bridgeMap = bridgeGame.move(secondMove, bridgeGame);


        //then
        assertEquals(List.of(" ", "O"), bridgeMap.getUpStatus());
        assertEquals(List.of("O", " "), bridgeMap.getDownStatus());
    }

    @DisplayName("게임 재시도 테스트")
    @Test
    void RetryGameTest() {
        //given
        List<String> bridge = List.of("U", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // 플레이어가 시도한 입력
        BridgeMove firstMove = new BridgeMove(Direction.UP, 0);
        BridgeMove secondMove = new BridgeMove(Direction.DOWN, 1);

        //when
        // 이동
        bridgeGame.move(firstMove, bridgeGame);
        bridgeGame.move(secondMove, bridgeGame);
        //재시도
        bridgeGame.retry();

        //then
        assertEquals(2, bridgeGame.getTryCount());
        assertTrue(bridgeGame.getBridgeMap().getUpStatus().isEmpty());
        assertTrue(bridgeGame.getBridgeMap().getDownStatus().isEmpty());
    }
}
