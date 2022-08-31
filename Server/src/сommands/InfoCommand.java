package сommands;

import collection.MyArrayList;

import java.io.IOException;

/**
 * info about collection
 */
public class InfoCommand implements Command {

    private final MyArrayList<?> myArrayList;
    /**
     * constructor
     * @param myArrayList
     */
    public InfoCommand(MyArrayList<?> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException {
        return "Тип: " + myArrayList.getClass().getSuperclass().getSimpleName() + "\n" +
                "Дата инициализации: " + myArrayList.getCreationDate().toString() + "\n" +
                "Количество элементов: " + myArrayList.size();
    }
}