package сommands;

import collection.MyArrayList;
import io.ServerPrint;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * command for remove by id
 */
public class RemoveByIdCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final long id;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param id
     */
    public RemoveByIdCommand(MyArrayList<Product> myArrayList, long id, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.id = id;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException {
        if (myArrayList.removeIf(elem -> elem.getId() == id))
            serverPrint.print(new Response("element was removed"));
        else
            serverPrint.print(new Response("no such element"));

    }
}
