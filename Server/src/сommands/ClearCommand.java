package сommands;

import collection.MyArrayList;

import java.io.IOException;

;

/**
 * class for clear collection
 */
public class ClearCommand implements Command{

    private final MyArrayList<?> myArrayList;
    /**
     * constructor
     * @param myArrayList
     */
    public ClearCommand(MyArrayList<?> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException {
        myArrayList.clear();
        return "collection has been cleared";

    }
}
