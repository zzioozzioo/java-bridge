package bridge.domain;

import bridge.exception.InvalidMovingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeMapTest {

    @DisplayName("맵에 진행 상황 추가할 때 R 또는 U가 아닌 값이 들어오면 예외가 발생")
    @Test
    void AddMapTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String firstDirection = "U";
        String firstStatus = "O";

        String secondDirection = "F";
        String secondStatus = "O";

        // 첫 번째 칸 이동
        //when
        bridgeMap.addMap(firstDirection, firstStatus);

        //then
        assertEquals(List.of("O"), bridgeMap.getUpStatus());

        // 두 번째 칸 이동
        //when & then
        assertThatThrownBy(() -> bridgeMap.addMap(secondDirection, secondStatus))
                .isInstanceOf(InvalidMovingException.class)
                .hasMessageContaining("[ERROR] 이동할 칸은 "
                        + Direction.UP.getDirection() + " 또는 "
                        + Direction.DOWN.getDirection() + "여야 합니다.");
    }

    @DisplayName("맵에 X가 있는지 테스트")
    @Test
    void ContainFailTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addMap("D", "O");
        bridgeMap.addMap("D", "X");

        //when
        boolean result = bridgeMap.containFail(bridgeMap);

        //then
        assertTrue(result);
    }

    @DisplayName("맵이 초기화되는지 테스트")
    @Test
    void ResetMapTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addMap("D", "O");
        bridgeMap.addMap("D", "X");

        //when
        bridgeMap.resetMap();

        //then
        assertTrue(bridgeMap.getUpStatus().isEmpty());
        assertTrue(bridgeMap.getDownStatus().isEmpty());
    }
}
