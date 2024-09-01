package bridge.constant;

public enum ErrorMessage {
    INVALID_SIZE("[ERROR] 다리의 길이는 "
            + ConstNumber.MIN_SIZE.getSize() + "과 "
            + ConstNumber.MAX_SIZE.getSize() + " 사이여야 합니다."),
    INVALID_MOVING("[ERROR] 이동할 칸은 "
            + ConstMessage.UP.getValue() + " 또는 "
            + ConstMessage.DOWN.getValue() + "여야 합니다."),
    INVALID_GAME_COMMAND("[ERROR] 게임 재시도 여부는 "
            + ConstMessage.RESTART.getValue() + " 또는 "
            + ConstMessage.QUIT.getValue() + "여야 합니다"),
    HAS_NOT_VALUE("[ERROR] 입력값이 비어있습니다."),
    IS_NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    IS_WRONG_LENGTH("[ERROR] 문자 하나만 입력해야 합니다."),
    IS_NOT_ALPHABET("[ERROR] 알파벳을 입력해야 합니다.");

    final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
