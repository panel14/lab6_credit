package utils.comparators;

import productclasses.Product;
import java.util.Comparator;

/**
 * comparator for products by unit of measure
 */
public class ProductUnitOfMeasureComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1 == o2)
            return 0;
        if (o1 == null)
            return -1;
        return o1.getUnitOfMeasure().compareTo(o2.getUnitOfMeasure());
    }
}
