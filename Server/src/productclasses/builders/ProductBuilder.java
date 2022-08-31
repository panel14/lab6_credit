package productclasses.builders;

import exceptions.MyException;
import io.Printable;
import io.Scannable;
import productclasses.Coordinates;
import productclasses.Person;
import productclasses.Product;
import productclasses.UnitOfMeasure;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Random;

/**
 * Class for build product
 */
public class ProductBuilder {
    private Product product;

    /**
     * constructor
     */
    public ProductBuilder(){
        product = new Product();
    }

    /**
     * method for build
     * @param scannable
     * @return
     * @throws MyException
     * @throws IOException
     */
    public Product build(Scannable scannable) throws MyException, IOException {
        this.buildName(scannable);
        this.buildId();
        this.buildCoordinates(scannable);
        this.buildPrice(scannable);
        this.buildCreationDate();
        this.buildUnitOfMeasure(scannable);
        this.buildOwner(scannable);

        return product;
    }

    /**
     * id
     * @throws MyException
     */
    public void buildId() throws MyException {
        Random random = new Random();
        long id = 0;
        while (id <= 0){
            id = random.nextLong();
        }

        product.setId(id);
    }

    /**
     * creation date
     * @throws MyException
     */
    public void buildCreationDate() throws MyException {
        product.setCreationDate(ZonedDateTime.now());
    }

    /**
     * name
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public void buildName(Scannable scannable) throws IOException, MyException {

        String name = scannable.readLine();
        try {
            product.setName(name);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * coordinates
     * @param scannable
     * @throws MyException
     * @throws IOException
     */
    public void buildCoordinates(Scannable scannable) throws MyException, IOException {
        CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder();
        Coordinates coordinates = coordinatesBuilder.build(scannable);
        product.setCoordinates(coordinates);
    }

    /**
     * price
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildPrice(Scannable scannable) throws IOException, MyException {

        String price = scannable.readLine();

        try {
            product.setPrice(Integer.valueOf(price));
        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * unit of measure
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildUnitOfMeasure(Scannable scannable) throws IOException, MyException {

        String unitOfMeasure = scannable.readLine();
        try{
            product.setUnitOfMeasure(UnitOfMeasure.valueOf(unitOfMeasure.toUpperCase(Locale.ROOT)));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * owner
     * @param scannable
     * @throws MyException
     * @throws IOException
     */
    public void buildOwner(Scannable scannable) throws MyException, IOException {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.build(scannable);

        product.setOwner(person);
    }
}
