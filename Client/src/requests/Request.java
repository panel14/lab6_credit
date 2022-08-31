package requests;

import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 17L;
    private CommandType type;
    private String[] commandArguments;

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public String[] getCommandInfo() {
        return commandArguments;
    }

    public void setCommandInfo(String[] commandArguments) {
        this.commandArguments = commandArguments;
    }

    public Request(CommandType type, String[] commandArguments) {
        this.type = type;
        this.commandArguments = commandArguments;
    }

    public Request() {}
}
