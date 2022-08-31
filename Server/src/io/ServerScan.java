package io;

import requests.Request;
import utils.Serializer;

import java.io.IOException;
import java.io.InputStream;

public class ServerScan {
    private final InputStream inputStream;

    public ServerScan(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public byte[] readBytes() throws IOException {
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        return buffer;
    }

    public Request readRequest() throws IOException, ClassNotFoundException {
        return (Request) Serializer.deserialize(readBytes());
    }
}
