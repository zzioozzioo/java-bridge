package bridge.domain;

import bridge.exception.InvalidGameCommandException;

import static bridge.util.Utility.match;

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
        return command.equals(restartCommand);
    }

    public static Command matchCommand(String command) {
        return match(Command.values(), command, new InvalidGameCommandException());
    }
}
