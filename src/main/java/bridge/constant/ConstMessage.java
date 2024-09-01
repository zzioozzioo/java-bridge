package bridge.constant;

public enum ConstMessage {

    UP("U"),
    DOWN("D"),

    RESTART("R"),
    QUIT("Q"),

    SUCCESS("성공"),
    FAIL("실패"),

    POSSIBLE("O"),
    IMPOSSIBLE("X"),

    START_GAME("다리 건너기 게임을 시작합니다."),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVING("이동할 칸을 선택해주세요. (위: " + ConstMessage.UP.getValue() + ", 아래: " + ConstMessage.DOWN.getValue() + ")"),
    READ_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + ConstMessage.RESTART.getValue() + ", 종료: " + ConstMessage.QUIT.getValue() + ")"),
    IS_SUCCESS("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: ");


    final String value;

    ConstMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
