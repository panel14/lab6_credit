package сommands;;

import collection.MyArrayList;
import io.ServerPrint;
import response.Response;

import java.io.IOException;

/**
 * class for clear collection
 */
public class ClearCommand implements Command{

    private final MyArrayList<?> myArrayList;
    private final ServerPrint serverPrint;
    /**
     * constructor
     * @param myArrayList
     */
    public ClearCommand(MyArrayList<?> myArrayList, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException {
        myArrayList.clear();
        serverPrint.print(new Response("collection has been cleared"));

    }
}
