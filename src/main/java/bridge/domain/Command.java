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

    public static Command matchCommand(String playerCommand) {
        for (Command cmd : Command.values()) {
            if (cmd.getCommand().equals(playerCommand)) {
                return cmd;
            }
        }
        throw new InvalidGameCommandException();
    }

    public boolean isEqualToRestartCommand(String restartCommand) {
        return this.command.equals(restartCommand);
    }
}
