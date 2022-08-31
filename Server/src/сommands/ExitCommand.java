package сommands;

import io.ServerPrint;
import response.Response;

import java.io.IOException;

/**
 * class for exit programm
 */
public class ExitCommand implements Command {
    private final ServerPrint serverPrint;

    public ExitCommand(ServerPrint serverPrint) {
        this.serverPrint = serverPrint;
    }
    @Override
    public void execute() throws IOException {
        serverPrint.print(new Response("#exit#"));
        System.exit(0);
    }
}
