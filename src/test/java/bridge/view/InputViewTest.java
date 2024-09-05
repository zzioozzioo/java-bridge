package bridge.view;

import bridge.exception.HasNotValueException;
import bridge.exception.IsNotAlphabetException;
import bridge.exception.IsNotNumberException;
import bridge.exception.IsWrongLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리 길이를 입력받을 때, 플레이어가 값을 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void HasValueTest_BridgeSize() {
        //given
        String input = " ";

        //when & then
        assertThatThrownBy(() -> inputView.hasValue(input))
                .isInstanceOf(HasNotValueException.class)
                .hasMessageContaining("[ERROR] 입력값이 비어있습니다.");

    }

    @DisplayName("플레이어가 숫자가 아닌 값을 입력한 경우 예외가 발생한다.")
    @Test
    void IsNumericTest() {
        //given
        String input = "숫자";

        //when & then
        assertThatThrownBy(() -> inputView.isNumeric(input))
                .isInstanceOf(IsNotNumberException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닙니다.");

    }

    @DisplayName("이동할 칸을 입력받을 때, 플레이어가 값을 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void HasValueTest_Moving() {
        //given
        String input = "";

        //when & then
        assertThatThrownBy(() -> inputView.hasValue(input))
                .isInstanceOf(HasNotValueException.class)
                .hasMessageContaining("[ERROR] 입력값이 비어있습니다.");
    }

    @DisplayName("이동할 칸을 입력받을 때, 플레이어가 여러 개의 값을 입력한 경우 예외가 발생한다.")
    @Test
    void IsRightLengthTest_Moving() {
        //given
        String input = "UD";

        //when & then
        assertThatThrownBy(() -> inputView.isRightLength(input))
                .isInstanceOf(IsWrongLengthException.class)
                .hasMessageContaining("[ERROR] 문자 하나만 입력해야 합니다.");
    }

    @DisplayName("이동할 칸을 입력받을 때, 플레이어가 문자가 아닌 값을 입력한 경우 예외가 발생한다.")
    @Test
    void IsAlphabetTest_Moving() {
        //given
        String input = "-";

        //when & then
        assertThatThrownBy(() -> inputView.isAlphabet(input))
                .isInstanceOf(IsNotAlphabetException.class)
                .hasMessageContaining("[ERROR] 알파벳을 입력해야 합니다.");
    }

    @DisplayName("게임 재시작/종료 여부를 입력받을 때, 플레이어가 값을 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void HasValueTest_Command() {
        //given
        String input = null;

        //when & then
        assertThatThrownBy(() -> inputView.hasValue(input))
                .isInstanceOf(HasNotValueException.class)
                .hasMessageContaining("[ERROR] 입력값이 비어있습니다.");
    }

    @DisplayName("게임 재시작/종료 여부를 입력받을 때, 플레이어가 여러 개의 값을 입력한 경우 예외가 발생한다.")
    @Test
    void IsRightLengthTest_Command() {
        //given
        String input = "RQR";

        //when & then
        assertThatThrownBy(() -> inputView.isRightLength(input))
                .isInstanceOf(IsWrongLengthException.class)
                .hasMessageContaining("[ERROR] 문자 하나만 입력해야 합니다.");
    }

    @DisplayName("게임 재시작/종료 여부를 입력받을 때, 플레이어가 문자가 아닌 값을 입력한 경우 예외가 발생한다.")
    @Test
    void IsAlphabetTest_Command() {
        //given
        String input = "8";

        //when & then
        assertThatThrownBy(() -> inputView.isAlphabet(input))
                .isInstanceOf(IsNotAlphabetException.class)
                .hasMessageContaining("[ERROR] 알파벳을 입력해야 합니다.");
    }
}