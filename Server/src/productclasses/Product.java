package productclasses;

import exceptions.MyException;

import java.time.ZonedDateTime;

/**
 * basic class product
 */
public class Product implements Comparable<Product> {
    /**
     * product id
     */
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * product name
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * product coordinates
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * product creation date
     */
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * product price
     */
    private Integer price; //Поле не может быть null, Значение поля должно быть больше 0
    /**
     * unit of measure product
     */
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    /**
     * product owner
     */
    private Person owner; //Поле не может быть null

    /**
     * product constructor
     */
    public Product(){}

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getPrice() {
        return price;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public long getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setCoordinates(Coordinates coordinates) throws MyException {
        if (coordinates == null){
            throw new MyException("coordinates can't be null");
        }

        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) throws MyException {
        if (creationDate == null){
            throw new MyException("creationdate can't be null");
        }
        this.creationDate = creationDate;
    }

    public void setId(long id) throws MyException {
        if (id <= 0)
            throw new MyException("id must be greater than 0");

        this.id = id;
    }

    public void setName(String name) throws MyException {
        if (name == null || name.isEmpty())
            throw new MyException("name can't be empty");

        this.name = name;
    }

    public void setOwner(Person owner) throws MyException {
        if (owner == null){
            throw new MyException("owner can't be null");
        }
        this.owner = owner;
    }


    public void setPrice(Integer price) throws MyException {
        if (price == null || price <= 0){
            throw new MyException("price must be greater than 0");
        }

        this.price = price;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws MyException {
        if (unitOfMeasure == null){
            throw new MyException("unitOfMeasure can't be null");
        }
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public String toString() {
        return "Product #" + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Coordinates: " + getCoordinates().toString() + "\n" +
                "CreationDate: " + creationDate.toString() + "\n" +
                "Price: " + getPrice() + "\n" +
                "UnitOfMeasure: " + getUnitOfMeasure() + "\n" +
                "Owner: " + owner.toString();
    }

    @Override
    public int compareTo(Product o) {
        if (o == null)
            return 1;
        return this.getName().length() - o.getName().length();
    }
}