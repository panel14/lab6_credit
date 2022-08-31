package сommands;

import collection.MyArrayList;
import productclasses.Product;

import java.io.IOException;

/**
 * class for add command
 */
public class AddCommand implements Command{
    private final MyArrayList<Product> myArrayList;
    private final Product product;

    /**
     * constructor
     * @param myArrayList
     * @param product
     */
    public AddCommand(MyArrayList<Product> myArrayList, Product product) {
        this.myArrayList = myArrayList;
        this.product = product;
    }

    @Override
    public String execute() throws IOException {
        myArrayList.add(product);
        return "Product added";
    }
}
