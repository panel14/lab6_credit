package io;

import response.Response;
import utils.Serializer;

import java.io.IOException;
import java.io.OutputStream;
/**
 * class for sending responses to client
 */
public class ServerPrint {

    private final OutputStream outputStream;

    /**
     * constructor
     * @param outputStream
     */
    public ServerPrint(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * send response to server
     * @param response
     * @throws IOException
     */
    public void print(Response response) throws IOException {
        byte[] responseBytes = Serializer.serialize(response);
        outputStream.write(responseBytes);
        outputStream.flush();
    }
}
