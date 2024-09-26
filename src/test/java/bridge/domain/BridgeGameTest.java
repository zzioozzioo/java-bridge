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
        List<String> bridge = List.of("D", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // 첫 번째 이동
        Direction firstDirection = Direction.DOWN;
        int firstIndex = 0;
        BridgeMove firstMove = new BridgeMove(firstDirection, firstIndex);

        // 두 번째 이동
        Direction secondDirection = Direction.UP;
        int secondIndex = 1;
        BridgeMove secondMove = new BridgeMove(secondDirection, secondIndex);

        //when
        BridgeMap bridgeMap;
        bridgeGame.move(firstMove);
        bridgeMap = bridgeGame.move(secondMove);


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

        BridgeMove firstMove = new BridgeMove(Direction.UP, 0);
        BridgeMove secondMove = new BridgeMove(Direction.DOWN, 1);

        //when
        bridgeGame.move(firstMove);
        bridgeGame.move(secondMove);
        bridgeGame.retry();

        //then
        assertEquals(2, bridgeGame.getTryCount());
        assertTrue(bridgeGame.getBridgeMap().getUpStatus().isEmpty());
        assertTrue(bridgeGame.getBridgeMap().getDownStatus().isEmpty());
    }
}
