package productclasses;

import exceptions.MyException;

import java.util.Objects;

/**
 * Class person
 */
public class Person implements Comparable<Person>{
    /**
     * name of product
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * passport
     */
    private String passportID; //Поле не может быть null
    /**
     * eye color
     */
    private Color eyeColor; //Поле может быть null
    /**
     * hair color
     */
    private Color hairColor; //Поле может быть null
    /**
     * nationality
     */
    private Country nationality; //Поле может быть null

    /**
     * empty constructor
     */
    public Person() {}

    public String getName() {
        return name;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setEyeColor(Color eyeColor) throws MyException {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(Color hairColor) throws MyException {
        this.hairColor = hairColor;
    }

    public void setName(String name) throws MyException {
        if (name == null || name.isEmpty()){
            throw new MyException("name can't be null");
        }
        this.name = name;
    }

    public void setNationality(Country nationality) throws MyException {
        this.nationality = nationality;
    }

    public void setPassportID(String passportID) throws MyException {
        if (passportID == null){
            throw new MyException("passportID can't be null");
        }
        this.passportID = passportID;
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Passport: " + this.getPassportID() + "\n" +
                "Eye color: " + this.eyeColor + "\n" +
                "Hair color: " + this.hairColor + "\n" +
                "Nationality: " + this.nationality;
    }

    @Override
    public int compareTo(Person o) {
        if (o == null)
            return 1;
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && passportID.equals(person.passportID) && eyeColor == person.eyeColor && hairColor == person.hairColor && nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportID, eyeColor, hairColor, nationality);
    }
}