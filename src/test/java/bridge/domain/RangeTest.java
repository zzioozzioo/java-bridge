package bridge.domain;

import bridge.exception.InvalidBridgeSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.Range.validateSize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @DisplayName("범위에서 벗어난 숫자가 입력되면 예외가 발생한다.")
    @Test
    void ValidateSizeTest() {
        //given
        int invalidBridgeSize = 2;

        //when & then
        assertThatThrownBy(() -> validateSize(invalidBridgeSize))
                .isInstanceOf(InvalidBridgeSizeException.class)
                .hasMessageContaining("[ERROR] 다리의 길이는 "
                        + Range.MIN_SIZE.getSize() + "과 "
                        + Range.MAX_SIZE.getSize() + " 사이여야 합니다.");
    }

}