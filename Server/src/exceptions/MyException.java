package exceptions;

/**
 * class for new exceptions
 */
public class MyException extends Exception {
    /**
     * empty constructor
     */
    public MyException() {
        super();
    }

    /**
     * constructor
     * @param message
     */
    public MyException(String message){
        super(message);
    }
}
