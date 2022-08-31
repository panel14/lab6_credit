package productclasses.builders;

import exceptions.MyException;
import io.Printable;
import io.Scannable;

import java.io.IOException;

/**
 * Class for build coordinates-
 */
public class CoordinatesStringBuilder {
    /**
     * check for console
     */
    private boolean isConsole;

    /**
     * constructor
     * @param isConsole check for console
     */
    public CoordinatesStringBuilder(boolean isConsole) {
        this.isConsole = isConsole;
    }

    /**
     * @param scannable scannable
     * @param printable printable
     * @return coordinates
     * @throws MyException
     * @throws IOException
     */
    public String build(Scannable scannable, Printable printable, char delimiter) throws MyException, IOException {

        return buildX(scannable, printable) + delimiter +
                buildY(scannable, printable);
    }

    /**
     * build x coordinates
     * @param scannable scannable
     * @param printable printable
     * @throws IOException
     * @throws MyException
     */
    public String buildX(Scannable scannable, Printable printable) throws IOException, MyException {
        while (true) {
            if (isConsole) {
                printable.println("Enter the coordinateX: ");
                String x = scannable.readLine();

                float xFloat = 0f;
                try {
                    xFloat = Float.parseFloat(x);
                    if (xFloat > 51){
                        printable.println("Incorrect data, repeat.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    printable.println(e.getMessage());
                    continue;
                }
                return x;
            }

            return scannable.readLine();
        }

    }

    /**
     * build y coordinate
     * @param scannable scannable
     * @param printable printable
     * @throws IOException
     * @throws MyException
     */
    public String buildY(Scannable scannable, Printable printable) throws IOException, MyException {
        while (true) {
            if (isConsole) {
                printable.println("Enter the coordinateY: ");
                String y = scannable.readLine();

                float yFloat = 0f;
                try {
                    yFloat = Float.parseFloat(y);
                } catch (NumberFormatException e) {
                    printable.println(e.getMessage());
                    continue;
                }
                return y;
            }

            return scannable.readLine();
        }
    }
}
