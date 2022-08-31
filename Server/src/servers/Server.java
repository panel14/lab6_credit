package servers;

import collection.MyArrayList;
import exceptions.MyException;
import io.FileScan;
import io.ServerPrint;
import io.ServerScan;
import productclasses.Product;
import requests.Request;
import response.Response;
import utils.CSVManager;
import сommands.CommandFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * main server class
 */
public class Server {

    private static final int PORT = 8888;
    public static String FILENAME;

    public static void main(String[] args) throws IOException, MyException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        ServerScan scan = new ServerScan(socket.getInputStream());
        ServerPrint send = new ServerPrint(socket.getOutputStream());

        MyArrayList<Product> myArrayList = getCollection();

        while (true) {
            try {
                Request request = scan.readRequest();
                String responseStr = CommandFactory.buildCommand(request, myArrayList).execute();
                Response response = new Response(responseStr);
                send.print(response);
            } catch (ClassNotFoundException e) {
                System.out.println("Ops!");
            }
        }
    }

    public static MyArrayList<Product> getCollection() throws IOException, MyException {
        MyArrayList<Product> myArrayList = new MyArrayList<>();
        FILENAME = System.getenv("VAR");

        if (FILENAME == null){
            System.out.println("There is no Env. var");
            System.exit(1);
        }
        if (Files.exists(Paths.get(FILENAME))){
            if (Files.isReadable(Paths.get(FILENAME))){
                StringBuilder stringBuilder = new StringBuilder();
                FileScan fileScan = new FileScan(FILENAME);

                while (fileScan.hasNext()){
                    stringBuilder.append(fileScan.readLine()).append("\n");
                }

                try {
                    myArrayList = CSVManager.toMyArrayList(stringBuilder.toString(), ',');
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return myArrayList;
    }
}
