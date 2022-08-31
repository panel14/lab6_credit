package сommands;

import collection.MyArrayList;
import productclasses.Product;

import java.io.IOException;

/**
 * command for remove by id
 */
public class RemoveByIdCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final long id;

    /**
     * constructor
     * @param myArrayList
     * @param id
     */
    public RemoveByIdCommand(MyArrayList<Product> myArrayList, long id) {
        this.myArrayList = myArrayList;
        this.id = id;
    }

    @Override
    public String execute() throws IOException {
        if (myArrayList.removeIf(elem -> elem.getId() == id))
            return "Element was removed";
        else
            return "No such element";

    }
}
