package bridge.domain;

import bridge.exception.InvalidGameCommandException;

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

    public boolean isEqualToRestartCommand(String restartCommand) {
        return this.command.equals(restartCommand);
    }
}
