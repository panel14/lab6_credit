package io;

import requests.Request;
import utils.Serializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * class for sending requests to server
 */
public class ClientPrint {

    private final SocketChannel socketChannel;

    /**
     * constructor
     * @param socketChannel
     */
    public ClientPrint(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    /**
     * send request to server
     * @param request
     * @throws IOException
     */
    public void print(Request request) throws IOException {
        byte[] bytes = Serializer.serialize(request);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        socketChannel.write(buffer);
    }
}