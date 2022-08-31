package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Product;

import java.io.IOException;

/**
 * update collection by id class
 */
public class UpdateCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final long id;
    private final Product product;

    /**
     * constructor
     * @param myArrayList
     * @param id
     * @param product
     */
    public UpdateCommand(MyArrayList<Product> myArrayList, long id, Product product) {
        this.myArrayList = myArrayList;
        this.id = id;
        this.product = product;
    }

    @Override
    public String execute() throws IOException, MyException {
        String response = "";
        if (myArrayList.removeIf(product1 -> product1.getId() == id))
            response = "Collection was update";
        else
            response = "Nothing to update";
        product.setId(id);
        myArrayList.add(product);
        return response;

    }
}
