package сommands;

import collection.MyArrayList;
import exceptions.MyException;
import io.FileScan;
import io.ServerPrint;
import productclasses.Product;
import response.Response;
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
    private final ServerPrint serverPrint;

    /**
     * constructor
     * @param myArrayList
     * @param fileName
     */
    public ExecuteScriptCommand(MyArrayList<Product> myArrayList, String fileName, ServerPrint serverPrint) {
        this.myArrayList = myArrayList;
        this.fileName = fileName;
        this.serverPrint = serverPrint;
    }

    @Override
    public void execute() throws IOException, MyException {
        File file = new File(fileName);
        if (FileHistory.getInstance().Contains(file)){
            throw new MyException("Recursion :/");
        }
        FileHistory.getInstance().addToHistory(file);
        FileScan fileScan = new FileScan(fileName);
        CommandManager commandManager = new CommandManager(myArrayList);
        while (fileScan.hasNext()){
            try {
                commandManager.getCommand(fileScan, serverPrint).execute();
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        FileHistory.getInstance().Remove(file);
        serverPrint.print(new Response("Script has been executed"));
    }
}
