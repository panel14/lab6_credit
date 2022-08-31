package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.FilePrint;
import productclasses.Product;
import servers.Server;
import utils.CSVManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * save collection
 */
public class SaveCommand implements Command{

    private final MyArrayList<Product> myArrayList;

    /**
     * constructor
     * @param myArrayList
     */
    public SaveCommand(MyArrayList<Product> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public String execute() throws IOException, MyException {
        String csv = CSVManager.toCSV(myArrayList, ',');
        if (!Files.exists(Paths.get(Server.FILENAME))){
            Files.createFile(Paths.get(Server.FILENAME));
        }

        if (!Files.isWritable(Paths.get(Server.FILENAME))){
            throw new MyException("Can't write to " + Server.FILENAME);
        }

        FilePrint filePrint = new FilePrint(Server.FILENAME);
        filePrint.println(csv);

        return "Collection was saved!";
    }
}
