package io;

import exceptions.MyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for scan file
 */
public class FileScan implements Scannable{

    /**
     * variable for read data from file
     */
    private InputStreamReader inputStreamReader;
    /**
     * check end of file
     */
    private boolean endOfFile = false;

    /**
     * constructor
     * @param filename
     * @throws IOException
     */
    public FileScan(String filename) throws IOException {
        inputStreamReader = new InputStreamReader(new FileInputStream(filename));
        if (inputStreamReader.read() == -1){
            endOfFile = true;
        }

        inputStreamReader = new InputStreamReader(new FileInputStream(filename));
    }

    /**
     * @return lines from file
     * @throws IOException
     * @throws MyException
     */
    @Override
    public String readLine() throws IOException, MyException {
        if (!hasNext())
            throw new MyException();

        StringBuilder stringBuilder = new StringBuilder();

        while (true){
            int c = inputStreamReader.read();

            if (c == -1){
                endOfFile = true;
                return stringBuilder.toString().replace("\r", "");
            }

            char ch = (char) c;

            if (ch == '\n'){
                return stringBuilder.toString().replace("\r", "");
            }

            stringBuilder.append(ch);
        }
    }

    /**
     * @return check next line
     */
    @Override
    public boolean hasNext() {
        return !endOfFile;
    }

    /**
     * @throws IOException close
     */
    @Override
    public void close() throws IOException {
        inputStreamReader.close();
    }
}
