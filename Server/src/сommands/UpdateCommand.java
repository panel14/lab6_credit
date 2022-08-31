package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.Printable;
import io.ServerPrint;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * update collection by id class
 */
public class UpdateCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final long id;
    private final Product product;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param id
     * @param product
     */
    public UpdateCommand(MyArrayList<Product> myArrayList, long id, Product product, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.id = id;
        this.product = product;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        if (myArrayList.removeIf(product1 -> product1.getId() == id))
            serverPrint.print(new Response("collection was update"));
        else
            serverPrint.print(new Response("nothing to update"));
        product.setId(id);
        myArrayList.add(product);

    }
}
