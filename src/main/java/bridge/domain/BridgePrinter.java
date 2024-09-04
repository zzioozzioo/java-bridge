package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

public class BridgePrinter {

    final String errorMsg = "[ERROR]";

    StringJoiner upStringJoiner;
    StringJoiner downStringJoiner;

    public BridgePrinter() {
        this.upStringJoiner = new StringJoiner(" | ", "[ ", " ]");
        this.downStringJoiner = new StringJoiner(" | ", "[ ", " ]");
    }

    public String matchStatusToDisplay(String status) {
        for (Status s : Status.values()) {
            if (status.equals(s.getStatus())) {
                return status;
            }
        }
        throw new IllegalArgumentException(errorMsg);
    }

    public void addStepBridge(String upStep, String downStep) {
        String upMoveResult = matchStatusToDisplay(upStep);
        String downMoveResult = matchStatusToDisplay(downStep);

        upStringJoiner.add(upMoveResult);
        downStringJoiner.add(downMoveResult);
    }

    public void addAllBridge(List<String> upStatus, List<String> downStatus) {
        for (int i = 0; i < upStatus.size(); i++) {
            String upStep = upStatus.get(i);
            String downStep = downStatus.get(i);
            addStepBridge(upStep, downStep);
        }
    }

    public String print() {
        return upStringJoiner.toString() + "\n" + downStringJoiner.toString() + "\n";
    }
}
