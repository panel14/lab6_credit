package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Product;
import utils.comparators.ProductComparator;

import java.io.IOException;

/**
 * sort collection class
 */
public class SortCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    /**
     * constructor
     * @param myArrayList
     */
    public SortCommand(MyArrayList<Product> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException, MyException {
        myArrayList.sort(new ProductComparator());
        return  "Collection was sorted";
    }
}
