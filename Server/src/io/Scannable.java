package io;

import exceptions.MyException;
import java.io.IOException;

/**
 * interface for scan
 */
public interface Scannable {
    /**
     * @return read line
     * @throws MyException
     * @throws IOException
     */
    String readLine() throws MyException, IOException;

    /**
     * @return check next line
     */
    boolean hasNext();

    /**
     * @throws IOException close
     */
    void close() throws IOException;
}
