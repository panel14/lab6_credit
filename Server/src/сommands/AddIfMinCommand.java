package сommands;


import collection.MyArrayList;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Product;
import response.Response;
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
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param product
     */
    public AddIfMinCommand(MyArrayList<Product> myArrayList, Product product, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.product = product;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        Optional<Product> minOpt = myArrayList.stream().min(new ProductComparator());
        if (!minOpt.isPresent()){
            serverPrint.print(new Response("Collection is empty"));
        }

        Product min = minOpt.get();
        if (product.compareTo(min) < 0)
            myArrayList.add(product);
        serverPrint.print(new Response("Element added)"));
    }
}
