package productclasses.builders;


import exceptions.MyException;
import io.Scannable;
import productclasses.Coordinates;
import java.io.IOException;

/**
 * Class for build coordinates-
 */
public class CoordinatesBuilder {
    /**
     * coordinates
     */
    private Coordinates coordinates;
    /**
     * check for console
     */

    /**
     * constructor
     */
    public CoordinatesBuilder() {
        coordinates = new Coordinates();
    }

    /**
     * @param scannable scannable
     * @return coordinates
     * @throws MyException
     * @throws IOException
     */
    public Coordinates build(Scannable scannable) throws MyException, IOException {
        this.buildX(scannable);
        this.buildY(scannable);

        return coordinates;
    }

    /**
     * build x coordinates
     * @param scannable scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildX(Scannable scannable) throws IOException, MyException {

        String x = scannable.readLine();
        try {
            coordinates.setX(Float.valueOf(x));
        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * build y coordinate
     * @param scannable scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildY(Scannable scannable) throws IOException, MyException {

        String y = scannable.readLine();

        try {
            coordinates.setY(Integer.valueOf(y));
        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
