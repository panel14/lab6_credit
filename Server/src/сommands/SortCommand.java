package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Product;
import response.Response;
import utils.comparators.ProductComparator;

import java.io.IOException;

/**
 * sort collection class
 */
public class SortCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final ServerPrint serverPrint;
    /**
     * constructor
     * @param myArrayList
     */
    public SortCommand(MyArrayList<Product> myArrayList, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        myArrayList.sort(new ProductComparator());
        serverPrint.print(new Response("Collection was sorted"));
    }
}
