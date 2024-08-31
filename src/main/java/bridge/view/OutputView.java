package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 문구 출력
     */
    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    /**
     * 게임 성공 여부 출력
     */
    public void printIsSuccess(String isSuccess) {
        System.out.println("게임 성공 여부: " + isSuccess);
    }

    /**
     * 시도 횟수 출력
     */
    public void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    /**
     * 에러 문구 출력?
     */
    public void printErrorMessage() {
    }
}
