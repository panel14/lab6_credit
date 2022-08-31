package сommands;

import exceptions.MyException;

import java.io.IOException;

/**
 * interface for commands
 */
public interface Command {
    /**
     * method for execute all commands
     * @throws IOException
     * @throws MyException
     */
    void execute() throws IOException, MyException, MyException;
}
