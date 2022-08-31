package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import productclasses.Person;
import productclasses.Product;

import java.io.IOException;

/**
 * command for filter by owner
 */
public class FilterGreaterThanOwnerCommand implements Command{

    private final Person person;
    private final MyArrayList<Product> myArrayList;

    /**
     * constructor
     * @param person
     * @param myArrayList
     */
    public FilterGreaterThanOwnerCommand(Person person, MyArrayList<Product> myArrayList) {
        this.person = person;
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException, MyException {
        StringBuilder stringBuilder = new StringBuilder();

        myArrayList.stream().filter(product -> product.getOwner().compareTo(person) > 0).forEach(product -> {
            stringBuilder.append(product).append("\n");;
        });
        return stringBuilder.toString();
    }
}
