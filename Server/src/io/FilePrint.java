package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class for print in file
 */
public class FilePrint implements Printable{

    /**
     * variable for writing data to file
     */
    private final FileOutputStream fileOutputStream;

    /**
     * @param filename constructor
     * @throws FileNotFoundException
     */
    public FilePrint(String filename) throws FileNotFoundException {
        fileOutputStream = new FileOutputStream(filename);
    }

    /**
     * println
     * @param s
     * @throws IOException
     */
    @Override
    public void println(String s) throws IOException {
        fileOutputStream.write((s + "\n").getBytes());
    }

    /**
     * print
     * @param s
     * @throws IOException
     */
    @Override
    public void print(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    /**
     * close
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
