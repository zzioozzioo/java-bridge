package bridge.constant;

public enum ConstMessage {

    START_GAME("다리 건너기 게임을 시작합니다.", "MESSAGE"),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요.", "MESSAGE"),
    READ_MOVING("이동할 칸을 선택해주세요. (위: " + Direction.UP.getDirection() + ", 아래: " + Direction.DOWN.getDirection() + ")", "MESSAGE"),
    READ_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + Command.RESTART.getCommand() + ", 종료: " + Command.QUIT.getCommand() + ")", "MESSAGE"),
    GAME_RESULT("최종 게임 결과", "MESSAGE"),
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
