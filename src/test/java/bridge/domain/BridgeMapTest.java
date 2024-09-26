package bridge.domain;

import bridge.exception.InvalidMovingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.domain.Direction.matchDirection;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeMapTest {

    @DisplayName("맵에 진행 상황 추가할 때 R 또는 U가 아닌 값이 들어오면 예외가 발생")
    @Test
    void AddMapTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String direction = "E";
        String status = "O";

        //when & then
        assertThatThrownBy(() -> bridgeMap.addMap(matchDirection(direction).getOperation(), status))
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

        String status = "O";

        //when
        bridgeMap.addUpStatus(status);
        bridgeMap.addEmptyToDownStatus();

        //then
        assertEquals(List.of("O"), bridgeMap.getUpStatus());
        assertEquals(List.of(" "), bridgeMap.getDownStatus());
    }

    @DisplayName("이동할 칸이 D일 때 맵에 추가 테스트")
    @Test
    void DownDirectionTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String status = "X";

        //when
        bridgeMap.addDownStatus(status);
        bridgeMap.addEmptyToUpStatus();

        //then
        assertEquals(List.of("X"), bridgeMap.getDownStatus());
        assertEquals(List.of(" "), bridgeMap.getUpStatus());
    }

    @DisplayName("맵에 X가 있는지 테스트")
    @Test
    void ContainFailTest() {
        //given
        BridgeMap bridgeMap = new BridgeMap();

        String direction1 = "D";
        String direction2 = "D";
        DirectionOperation operation1 = matchDirection(direction1).getOperation();
        DirectionOperation operation2 = matchDirection(direction2).getOperation();

        bridgeMap.addMap(operation1, "O");
        bridgeMap.addMap(operation2, "X");

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

        String direction1 = "D";
        String direction2 = "D";
        DirectionOperation operation1 = matchDirection(direction1).getOperation();
        DirectionOperation operation2 = matchDirection(direction2).getOperation();

        bridgeMap.addMap(operation1, "O");
        bridgeMap.addMap(operation2, "X");

        //when
        bridgeMap.resetMap();

        //then
        assertTrue(bridgeMap.getUpStatus().isEmpty());
        assertTrue(bridgeMap.getDownStatus().isEmpty());
    }
}
