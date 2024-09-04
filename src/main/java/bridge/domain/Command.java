package bridge.domain;

import bridge.constant.ConstMessage;
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

    public boolean isEqualCommand(String restartCommand) {
        if (this.command.equals(restartCommand)) {
            return true;
        }
        return false;
    }
}
