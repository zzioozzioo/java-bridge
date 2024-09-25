package bridge.domain;

import bridge.exception.InvalidGameCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.Command.matchCommand;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {

    @DisplayName("플레이어가 입력한 재시도/종료 여부와 Command 상수 매치 테스트")
    @Test
    void MatchCommandTest() {
        //given
        String playerCommand = "S";

        //when & then
        assertThatThrownBy(() -> matchCommand(playerCommand))
                .isInstanceOf(InvalidGameCommandException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("플레이어가 입력한 재시도/종료 여부와 RESTART 상수가 일치하는지 테스트")
    @Test
    void IsEqualToRestartCommandTest() {
        //given

        Command command = matchCommand("R");
        String restartCommand = "R";

        //when
        boolean result = command.isEqualToRestartCommand(restartCommand);

        //then
        assertTrue(result);
    }
}
