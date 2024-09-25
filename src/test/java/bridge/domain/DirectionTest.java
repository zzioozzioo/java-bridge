package bridge.domain;

import bridge.exception.InvalidMovingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.Direction.matchDirection;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("플레이어가 입력한 이동할 칸과 Direction 상수 매치 테스트")
    @Test
    void MatchDirectionTest() {
        //given
        String str = "u";

        //when & then
        assertThatThrownBy(() -> matchDirection(str))
                .isInstanceOf(InvalidMovingException.class)
                .hasMessageContaining("[ERROR] 이동할 칸은 "
                        + Direction.UP.getDirection() + " 또는 "
                        + Direction.DOWN.getDirection() + "여야 합니다.");
    }
}