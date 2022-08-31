package io;

import requests.Request;
import utils.Serializer;

import java.io.IOException;
import java.io.InputStream;

/**
 * class for receiving client's requests
 */
public class ServerScan {
    private final InputStream inputStream;

    /**
     * constructor
     * @param inputStream
     */
    public ServerScan(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * read serialized request (as bytes array)
     * @return
     * @throws IOException
     */
    public byte[] readBytes() throws IOException {
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        return buffer;
    }

    /**
     * reading request as string (deserializing)
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Request readRequest() throws IOException, ClassNotFoundException {
        return (Request) Serializer.deserialize(readBytes());
    }
}
