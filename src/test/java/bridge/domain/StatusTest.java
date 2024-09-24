package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    @DisplayName("현재 이동할 칸과 다리를 비교해 건널 수 있는지 여부 매치 테스트")
    @Test
    void MatchStatusTest() {
        //given
        String direction = "U";
        List<String> bridge = List.of("U", "U", "D");
        int index = 0;

        //when
        Status status = Status.POSSIBLE.match(direction, bridge.get(index));

        //then
        assertEquals(Status.POSSIBLE, status);
    }
}