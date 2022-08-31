package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.Printable;
import io.ServerPrint;
import productclasses.Person;
import productclasses.Product;
import response.Response;

import java.io.IOException;

/**
 * command for filter by owner
 */
public class FilterGreaterThanOwnerCommand implements Command{

    private final Person person;
    private final MyArrayList<Product> myArrayList;
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param person
     * @param myArrayList
     */
    public FilterGreaterThanOwnerCommand(Person person, MyArrayList<Product> myArrayList, ServerPrint serverPrint) {
        this.person = person;
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        StringBuilder stringBuilder = new StringBuilder();

        myArrayList.stream().filter(product -> product.getOwner().compareTo(person) > 0).forEach(product -> {
            stringBuilder.append(product).append("\n");;
        });
        serverPrint.print(new Response(stringBuilder.toString()));
    }
}
