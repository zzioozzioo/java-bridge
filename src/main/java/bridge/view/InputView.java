package bridge.view;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        hasValue(input);
        isNumeric(input);
    }

    private void hasValue(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = readLine();
        validateChar(input);
        return input;
    }

    private void validateChar(String input) {
        hasValue(input);
        isRightLength(input);
        isAlphabet(input);
    }

    private static void isRightLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    private void isAlphabet(String input) {
        char target = input.charAt(0);
        if (!Character.isAlphabetic(target)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
        String input = readLine();
        validateChar(input);
        return input;
    }

}
