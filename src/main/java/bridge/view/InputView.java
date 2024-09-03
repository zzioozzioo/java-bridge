package bridge.view;

import bridge.constant.ConstMessage;
import bridge.exception.*;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(ConstMessage.READ_BRIDGE_SIZE.getValue());
                String input = readLine();
                validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch (HasNotValueException | IsNotNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 다리 길이 유효성 검사
     */
    private void validateBridgeSize(String input) {
        hasValue(input);
        isNumeric(input);
    }

    private void hasValue(String input) {
        if (input == null || input.isEmpty()) {
            throw new HasNotValueException();
        }
    }

    private void isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IsNotNumberException();
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(ConstMessage.READ_MOVING.getValue());
                String input = readLine();
                validateChar(input);
                return input;
            } catch (HasNotValueException | IsWrongLengthException | IsNotAlphabetException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println(ConstMessage.READ_GAME_COMMAND.getValue());
                String input = readLine();
                validateChar(input);
                return input;
            } catch (HasNotValueException | IsWrongLengthException | IsNotAlphabetException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 알파벳 유효성 검사
     */
    private void validateChar(String input) {
        hasValue(input);
        isRightLength(input);
        isAlphabet(input);
    }

    private static void isRightLength(String input) {
        if (input.length() != 1) {
            throw new IsWrongLengthException();
        }
    }

    private void isAlphabet(String input) {
        char target = input.charAt(0);
        if (!Character.isAlphabetic(target)) {
            throw new IsNotAlphabetException();
        }
    }

}
