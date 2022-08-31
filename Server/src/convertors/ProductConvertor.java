package convertors;

import exceptions.MyException;
import productclasses.Coordinates;
import productclasses.Person;
import productclasses.Product;
import productclasses.UnitOfMeasure;

import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * class for converting product-string to product class
 */
public class ProductConvertor {

    public static Product convert(String string) throws MyException {
        String[] args = string.split(",");

        Product product = new Product();
        product.setName(args[0]);
        product.setId(Long.parseLong(args[1]));

        Coordinates coordinates = CoordinatesConvertor.convert(new String[] {args[2], args[3]});
        product.setCoordinates(coordinates);

        product.setPrice(Integer.parseInt(args[4]));

        ZonedDateTime time = ZonedDateTime.parse(args[5]);
        product.setCreationDate(time);

        product.setUnitOfMeasure(UnitOfMeasure.valueOf(args[6].toUpperCase(Locale.ROOT)));

        Person person = PersonConvertor.convert(args[7]);
        product.setOwner(person);

        return product;
    }
}
