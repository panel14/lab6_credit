package сommands;

import collection.MyArrayList;
import io.ServerPrint;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * class for add command
 */
public class AddCommand implements Command{
    private final MyArrayList<Product> myArrayList;
    private final Product product;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param product
     */
    public AddCommand(MyArrayList<Product> myArrayList, Product product, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.product = product;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException {
        myArrayList.add(product);
        serverPrint.print(new Response("Product added"));
    }
}
