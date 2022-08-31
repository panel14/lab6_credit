package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * InsertAtCommand
 */
public class InsertAtCommand implements Command{

    private final Product product;
    private final int index;
    private final MyArrayList<Product> myArrayList;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param product
     * @param index
     * @param myArrayList
     */
    public InsertAtCommand(Product product, int index, MyArrayList<Product> myArrayList, ServerPrint serverPrint) {
        this.product = product;
        this.index = index;
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        if (index >= 0 && index <= myArrayList.size() )
        myArrayList.add(index, product);
        serverPrint.print(new Response("Product was added"));
    }
}
