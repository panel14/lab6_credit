package сommands;


import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Product;
import utils.comparators.ProductComparator;

import java.io.IOException;
import java.util.Optional;

/**
 * class for add command if min
 */
public class AddIfMinCommand implements Command{

    /**
     * local collection
     */
    private final MyArrayList<Product> myArrayList;
    /**
     * product
     */
    private final Product product;

    /**
     * constructor
     * @param myArrayList
     * @param product
     */
    public AddIfMinCommand(MyArrayList<Product> myArrayList, Product product) {
        this.myArrayList = myArrayList;
        this.product = product;
    }

    @Override
    public String execute() throws IOException, MyException {
        Optional<Product> minOpt = myArrayList.stream().min(new ProductComparator());
        if (!minOpt.isPresent()){
            return "Collection is empty";
        }

        Product min = minOpt.get();
        if (product.compareTo(min) < 0)
            myArrayList.add(product);
        return "Element added";
    }
}
