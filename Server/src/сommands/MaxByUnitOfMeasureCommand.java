package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Product;
import utils.comparators.ProductUnitOfMeasureComparator;

import java.io.IOException;
import java.util.Optional;

/**
 * MaxByUnitOfMeasureCommand
 */
public class MaxByUnitOfMeasureCommand implements Command{

    private final MyArrayList<Product> myArrayList;

    /**
     * constructor
     * @param myArrayList
     */
    public MaxByUnitOfMeasureCommand(MyArrayList<Product> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException, MyException {
        Optional<Product> maxOpt = myArrayList.stream().max(new ProductUnitOfMeasureComparator());

        if (!maxOpt.isPresent()){
            return "There is no max element";
        }
        else
            return maxOpt.get().toString();
    }
}
