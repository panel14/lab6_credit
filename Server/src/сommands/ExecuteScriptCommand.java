package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.FileScan;
import productclasses.Product;
import utils.CommandManager;
import utils.FileHistory;

import java.io.File;
import java.io.IOException;

/**
 * ExecuteScriptCommand
 */
public class ExecuteScriptCommand implements Command{

    private final MyArrayList<Product> myArrayList;
    private final String fileName;

    /**
     * constructor
     * @param myArrayList
     * @param fileName
     */
    public ExecuteScriptCommand(MyArrayList<Product> myArrayList, String fileName) {
        this.myArrayList = myArrayList;
        this.fileName = fileName;
    }

    @Override
    public String execute() throws IOException, MyException {
        File file = new File(fileName);
        if (FileHistory.getInstance().Contains(file)){
            throw new MyException("Recursion :/");
        }
        FileHistory.getInstance().addToHistory(file);
        FileScan fileScan = new FileScan(fileName);
        CommandManager commandManager = new CommandManager(myArrayList);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileScan.hasNext()){
            try {
                stringBuilder.append(commandManager.getCommand(fileScan).execute()).append("\n\n");
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        stringBuilder.append("Script has been executed");
        FileHistory.getInstance().Remove(file);
        return stringBuilder.toString();
    }
}
