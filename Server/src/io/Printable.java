package io;

import java.io.IOException;

/**
 * interface for print
 */
public interface Printable {
    /**
     * @param s println
     * @throws IOException
     */
    void println(String s) throws IOException;

    /**
     * @param s print
     * @throws IOException
     */
    void print(String s) throws IOException;

    /**
     * @throws IOException close
     */
    void close() throws IOException;
}
