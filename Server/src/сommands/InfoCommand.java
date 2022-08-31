package сommands;

import collection.MyArrayList;
import io.ServerPrint;
import response.Response;

import java.io.IOException;

/**
 * info about collection
 */
public class InfoCommand implements Command {

    private final MyArrayList<?> myArrayList;
    private final ServerPrint serverPrint;
    /**
     * constructor
     * @param myArrayList
     */
    public InfoCommand(MyArrayList<?> myArrayList, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException {
        serverPrint.print(new Response("Тип: " + myArrayList.getClass().getSuperclass().getSimpleName() + "\n" +
                "Дата инициализации: " + myArrayList.getCreationDate().toString() + "\n" +
                "Количество элементов: " + myArrayList.size()));
    }
}