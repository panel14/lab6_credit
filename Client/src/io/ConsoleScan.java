package io;

import exceptions.MyException;

import java.util.Scanner;

/**
 * Class for scan from console
 */
public class ConsoleScan implements Scannable{
    /**
     * scanner
     */
    Scanner scanner;

    /**
     * empty constructor
     */
    public ConsoleScan(){
        scanner = new Scanner(System.in);
    }

    /**
     * @return lines from console
     */
    @Override
    public String readLine() throws MyException {
        if (!scanner.hasNextLine())
            System.exit(1);
        return scanner.nextLine();
    }

    /**
     * @return check next line
     */
    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    /**
     * close
     */
    @Override
    public void close() {
        scanner.close();
    }
}