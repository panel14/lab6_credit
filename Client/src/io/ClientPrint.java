package io;

import requests.Request;
import utils.Serializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientPrint {

    private final SocketChannel socketChannel;

    public ClientPrint(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void print(Request request) throws IOException {
        byte[] bytes = Serializer.serialize(request);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        socketChannel.write(buffer);
    }
}