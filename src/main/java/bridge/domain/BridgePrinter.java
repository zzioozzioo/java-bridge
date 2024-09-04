package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

public class BridgePrinter {

    StringJoiner upStringJoiner;
    StringJoiner downStringJoiner;

    public BridgePrinter() {
        this.upStringJoiner = new StringJoiner(" | ", "[ ", " ]");
        this.downStringJoiner = new StringJoiner(" | ", "[ ", " ]");
    }


    public void addStepBridge(String upStep, String downStep) {
        upStringJoiner.add(upStep);
        downStringJoiner.add(downStep);
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
