package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Person;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * command for remove by owner
 */
public class RemoveAllByOwnerCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final Person owner;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param owner
     */
    public RemoveAllByOwnerCommand(MyArrayList<Product> myArrayList, Person owner, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.owner = owner;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        if (myArrayList.removeIf(elem -> elem.getOwner().equals(owner)))
            serverPrint.print(new Response("Products were removed"));
        else
            serverPrint.print(new Response("No elements to remove"));

    }
}
