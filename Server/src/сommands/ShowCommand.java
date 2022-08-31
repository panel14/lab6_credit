package сommands;

import collection.MyArrayList;
import io.ServerPrint;
import response.Response;

import java.io.IOException;

/**
 * show collection
 */
public class ShowCommand implements Command{

    private final MyArrayList<?> myArrayList;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     */
    public ShowCommand(MyArrayList<?> myArrayList, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        myArrayList.forEach(elem -> {
            stringBuilder.append(elem.toString()).append("\n").append("\n");
        });
        serverPrint.print(new Response(stringBuilder.toString()));
    }
}
