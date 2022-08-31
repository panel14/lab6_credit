package productclasses.builders;

import exceptions.MyException;
import io.Printable;
import io.Scannable;
import productclasses.enums.UnitOfMeasure;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

/**
 * Class for build product
 */
public class ProductStringBuilder {
    private boolean isConsole;

    /**
     * constructor
     * @param isConsole
     */
    public ProductStringBuilder(boolean isConsole){
        this.isConsole = isConsole;
    }

    /**
     * method for build
     * @param scannable
     * @param printable
     * @return
     * @throws MyException
     * @throws IOException
     */
    public String build(Scannable scannable, Printable printable, char delimiter) throws MyException, IOException {

        return buildName(scannable, printable) + delimiter +
                buildId() + delimiter +
                buildCoordinates(scannable, printable, delimiter) + delimiter +
                buildPrice(scannable, printable) + delimiter +
                buildCreationDate() + delimiter +
                buildUnitOfMeasure(scannable, printable) + delimiter +
                buildOwner(scannable, printable) + delimiter;
    }

    /**
     * id
     */
    public String buildId() {
        Random random = new Random();
        long id = 0;
        while (id <= 0){
            id = random.nextLong();
        }

        return Long.toString(id);
    }

    /**
     * creation date
     */
    public String buildCreationDate() {
        return ZonedDateTime.now().toString();
    }

    /**
     * name
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildName(Scannable scannable, Printable printable) throws IOException, MyException {
        while (true) {
            if (isConsole) {
                printable.println("Enter the name: ");
                String name = scannable.readLine();
                if (name == null || name.isEmpty()){
                    printable.println("name can't be empty");
                    continue;
                }
                return name;
            }

            return scannable.readLine();
        }
    }

    /**
     * coordinates
     * @param scannable
     * @param printable
     * @throws MyException
     * @throws IOException
     */
    public String buildCoordinates(Scannable scannable, Printable printable, char delimiter) throws MyException, IOException {
        CoordinatesStringBuilder coordinatesBuilder = new CoordinatesStringBuilder(isConsole);
        return coordinatesBuilder.build(scannable, printable, delimiter);
    }

    /**
     * price
     * @param scannable
     * @param printable
     * @throws IOException
     */
    public String buildPrice(Scannable scannable, Printable printable) throws IOException, MyException {
        while (true){
            if (isConsole){
                printable.println("Enter the price: ");
                String price = scannable.readLine();

                int priceInt = 1;
                try {
                    priceInt = Integer.parseInt(price);
                } catch (NumberFormatException e) {
                    printable.println(e.getMessage());
                }

                if (price.equals("") || priceInt <= 0) {
                    printable.println("price must be greater than 0");
                    continue;
                }
                return price;
            }
            return scannable.readLine();
        }
    }

    /**
     * unit of measure
     * @param scannable
     * @param printable
     * @throws IOException
     */
    public String buildUnitOfMeasure(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            while (true){
                printable.println("Enter the unitOfMeasure " + Arrays.toString(UnitOfMeasure.values()) + ":");
                String unitOfMeasure = scannable.readLine();

                try{
                    UnitOfMeasure testMeasure = (UnitOfMeasure.valueOf(unitOfMeasure.toUpperCase(Locale.ROOT)));
                } catch (Exception e){
                    printable.println("Error: " + e.getMessage());
                    continue;
                }

                return unitOfMeasure;
            }
        }
        return scannable.readLine();
    }

    /**
     * owner
     * @param scannable
     * @param printable
     * @throws MyException
     * @throws IOException
     */
    public String buildOwner(Scannable scannable, Printable printable) throws MyException, IOException {
        PersonStringBuilder personBuilder = new PersonStringBuilder(isConsole);
        return personBuilder.build(scannable, printable, ';');
    }
}
