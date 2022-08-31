package сommands;

import collection.MyArrayList;

import java.io.IOException;

/**
 * show collection
 */
public class ShowCommand implements Command{

    private final MyArrayList<?> myArrayList;

    /**
     * constructor
     * @param myArrayList
     */
    public ShowCommand(MyArrayList<?> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        myArrayList.forEach(elem -> {
            stringBuilder.append(elem.toString()).append("\n").append("\n");
        });
        return stringBuilder.toString();
    }
}
