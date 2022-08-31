package io;

import response.Response;
import utils.Serializer;
import java.io.IOException;
import java.io.OutputStream;

public class ServerPrint {

    private final OutputStream outputStream;

    public ServerPrint(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(Response response) throws IOException {
        byte[] responseBytes = Serializer.serialize(response);
        outputStream.write(responseBytes);
        outputStream.flush();
    }
}
