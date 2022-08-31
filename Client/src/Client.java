import exceptions.MyException;
import io.ClientPrint;
import io.ClientScan;
import io.ConsolePrint;
import io.ConsoleScan;
import requests.CommandType;
import requests.Request;
import service.RequestManager;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

;

/**
 * main client class
 */
public class Client {

    private static final String LOCALHOST = "localhost";
    private static final int PORT = 8888;
    private static SocketChannel socketChannel;

    public static void main(String[] args) throws IOException {
        ConsoleScan consoleScan = new ConsoleScan();
        ConsolePrint consolePrint = new ConsolePrint();
        boolean isConnected = false;

        while (!isConnected) {
            try {
                configure();
            } catch (ConnectException e) {
                consolePrint.println("Await of connection...");
                continue;
            }
            isConnected = true;
        }

        ClientPrint clientPrint = new ClientPrint(socketChannel);
        ClientScan clientScan = new ClientScan(socketChannel);

        while (true) {
            try {
                Request request = RequestManager.getRequest(consoleScan, consolePrint, true);
                clientPrint.print(request);
                if (request.getType() == CommandType.EXIT){
                    consolePrint.println("Shut down");
                    System.exit(0);
                }
                String answer = clientScan.readString();
                consolePrint.println(answer);
            }
            catch (MyException | ClassNotFoundException e) {
                consolePrint.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * main servers configurations
     * @throws IOException
     */
    public static void configure() throws IOException {
        SocketAddress address = new InetSocketAddress(LOCALHOST, PORT);
        socketChannel = SocketChannel.open();
        socketChannel.connect(address);
        socketChannel.configureBlocking(false);
    }
}
