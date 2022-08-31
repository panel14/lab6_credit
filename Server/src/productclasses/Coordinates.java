package productclasses;

import exceptions.MyException;

/**
 * Class coordinates
 */
public class Coordinates {
    /**
     * x
     */
    private Float x; //Максимальное значение поля: 51, Поле не может быть null
    /**
     * y
     */
    private Integer y; //Поле не может быть null

    /**
     * empty constructor
     */
    public Coordinates() {}

    /**
     * @return x
     */
    public Float getX() {
        return x;
    }

    /**
     * @return y
     */
    public Integer getY() {
        return y;
    }

    public void setX(Float x) throws MyException {
        if (x == null || x > 51){
            throw new MyException("x must be lower than 51");
        }
        this.x = x;

    }

    public void setY(Integer y) throws MyException {
        if (y == null){
            throw new MyException("y can't be null");
        }
        this.y = y;
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "(" + this.getX() + "; " + this.getY() + ")";
    }
}