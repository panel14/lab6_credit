package сommands;

import java.io.IOException;

/**
 * class for exit programm
 */
public class ExitCommand implements Command {

    @Override
    public String execute() throws IOException {
        System.exit(0);
        return "bye";
    }
}
