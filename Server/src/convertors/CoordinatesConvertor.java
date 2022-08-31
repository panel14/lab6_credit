package convertors;

import exceptions.MyException;
import productclasses.Coordinates;

/**
 * class for converting coordinates-string to coordinates class
 */
public class CoordinatesConvertor {

    public static Coordinates convert(String[] args) throws MyException {
        float x = Float.parseFloat(args[0]);
        int y = Integer.parseInt(args[1]);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);

        return coordinates;
    }
}
