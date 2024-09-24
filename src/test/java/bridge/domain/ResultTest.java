package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.util.Utility.matchResult;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @DisplayName("게임 성공 여부와 Result 상수의 값 매치 테스트")
    @Test
    void MatchResultTest() {
        //given
        boolean flag = true;

        //when
        String result = matchResult(flag);

        //then
        assertEquals("성공", result);
    }
}