package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Product;
import response.Response;
import utils.comparators.ProductUnitOfMeasureComparator;

import java.io.IOException;
import java.util.Optional;

/**
 * MaxByUnitOfMeasureCommand
 */
public class MaxByUnitOfMeasureCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     */
    public MaxByUnitOfMeasureCommand(MyArrayList<Product> myArrayList, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        Optional<Product> maxOpt = myArrayList.stream().max(new ProductUnitOfMeasureComparator());

        if (!maxOpt.isPresent()){
            serverPrint.print(new Response("There is no max element"));
        }
        else
            serverPrint.print(new Response(maxOpt.get().toString()));
    }
}
