package io;

/**
 * Class for print on console
 */
public class ConsolePrint implements Printable {
    /**
     * to console with new line
     * @param s
     */
    @Override
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * to console
     * @param s
     */
    @Override
    public void print(String s) {
        System.out.print(s);
    }

    /**
     * close
     */
    @Override
    public void close() {

    }
}
