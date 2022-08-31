package io;

import response.Response;
import utils.Serializer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientScan {

    private final SocketChannel socketChannel;
    private Selector selector;

    public ClientScan(SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ, null);
    }

    public String readString() throws IOException, ClassNotFoundException {

        while (true) {
            if (selector.select(5000) == 0) {
                throw new RuntimeException("404");
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            Response response = new Response();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey key = selectionKeyIterator.next();
                selectionKeyIterator.remove();
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(10000);
                    try {
                        socketChannel.read(buffer);
                    } catch (Exception e) {
                        throw new RuntimeException("Error 404");
                    }
                    response = (Response) Serializer.deserialize(buffer.array());

                }
            }
            return response.getResponse();
        }
    }
}
