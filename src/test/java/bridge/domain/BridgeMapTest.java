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

        String direction = "u";
        String status = "O";

        //when & then
        assertThatThrownBy(() -> bridgeMap.addMap(direction, status))
                .isInstanceOf(InvalidMovingException.class)
                .hasMessageContaining("[ERROR] 이동할 칸은 "
                        + Direction.UP.getDirection() + " 또는 "
                        + Direction.DOWN.getDirection() + "여야 합니다.");
    }

    @DisplayName("이동할 칸이 U일 때 맵에 추가 테스트")
    @Test
    void UpDirectionTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String direction = "U";
        String status = "O";

        //when
        bridgeMap.upDirection(direction, status);

        //then
        assertEquals(List.of("O"), bridgeMap.getUpStatus());
    }

    @DisplayName("이동할 칸이 D일 때 맵에 추가 테스트")
    @Test
    void DownDirectionTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String direction = "D";
        String status = "X";

        //when
        bridgeMap.downDirection(direction, status);

        //then
        assertEquals(List.of("X"), bridgeMap.getDownStatus());
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
