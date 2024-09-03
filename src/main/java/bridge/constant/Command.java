package bridge.constant;

public enum Command {

    RESTART("R"),
    QUIT("Q");

    final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
