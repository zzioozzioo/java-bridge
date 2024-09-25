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

    public static Command matchCommand(String command) {
//        return match(Command.values(), command, new InvalidGameCommandException());
        for (Command cmd : Command.values()) {
            if (cmd.getCommand().equals(command)) {
                return cmd;
            }
        }
        throw new InvalidGameCommandException();
    }
}
