package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Product;

import java.io.IOException;

/**
 * InsertAtCommand
 */
public class InsertAtCommand implements Command{

    private final Product product;
    private final int index;
    private final MyArrayList<Product> myArrayList;

    /**
     * constructor
     * @param product
     * @param index
     * @param myArrayList
     */
    public InsertAtCommand(Product product, int index, MyArrayList<Product> myArrayList) {
        this.product = product;
        this.index = index;
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException, MyException {
        if (index >= 0 && index <= myArrayList.size() )
        myArrayList.add(index, product);
        return "Product was added";
    }
}
