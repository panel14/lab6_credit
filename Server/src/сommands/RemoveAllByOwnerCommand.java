package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Person;
import productclasses.Product;

import java.io.IOException;

/**
 * command for remove by owner
 */
public class RemoveAllByOwnerCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final Person owner;

    /**
     * constructor
     * @param myArrayList
     * @param owner
     */
    public RemoveAllByOwnerCommand(MyArrayList<Product> myArrayList, Person owner) {
        this.myArrayList = myArrayList;
        this.owner = owner;
    }

    @Override
    public String execute() throws IOException, MyException {
        if (myArrayList.removeIf(elem -> elem.getOwner().equals(owner)))
            return "Products were removed";
        else
            return "No elements to remove";

    }
}
