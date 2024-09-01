package bridge.constant;

public enum ConstMessage {

    UP("U", "DIRECTION"),
    DOWN("D", "DIRECTION"),

    RESTART("R", "COMMAND"),
    QUIT("Q", "COMMAND"),

    SUCCESS("성공", "RESULT"),
    FAIL("실패", "RESULT"),

    POSSIBLE("O", "STATUS"),
    IMPOSSIBLE("X", "STATUS"),

    START_GAME("다리 건너기 게임을 시작합니다.", "MESSAGE"),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요.", "MESSAGE"),
    READ_MOVING("이동할 칸을 선택해주세요. (위: " + ConstMessage.UP.getValue() + ", 아래: " + ConstMessage.DOWN.getValue() + ")", "MESSAGE"),
    READ_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + ConstMessage.RESTART.getValue() + ", 종료: " + ConstMessage.QUIT.getValue() + ")", "MESSAGE"),
    IS_SUCCESS("게임 성공 여부: ", "MESSAGE"),
    TRY_COUNT("총 시도한 횟수: ", "MESSAGE");


    final String value;
    final String type;

    ConstMessage(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }
}
