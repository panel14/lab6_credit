package collection;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * @param <T> Collection from ArrayList with creation date
 */
public class MyArrayList<T> extends ArrayList<T> {

    /**
     * collection creation date
     */
    private ZonedDateTime creationDate;

    /**
     *  constructor for new collection
     */
    public MyArrayList(){
        super();
        creationDate = ZonedDateTime.now();
    }

    /**
     * @return creation date
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate
     */
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
