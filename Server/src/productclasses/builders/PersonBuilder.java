package productclasses.builders;

import exceptions.MyException;
import io.Printable;
import io.Scannable;
import productclasses.Color;
import productclasses.Country;
import productclasses.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * class for building person
 */
public class PersonBuilder {
    /**
     * person
     */
    private Person person;

    /**
     * constructor
     */
    public PersonBuilder() {
        person = new Person();
    }

    /**
     * main method for build
     * @param scannable
     * @return
     * @throws IOException
     */
    public Person build(Scannable scannable) throws MyException, IOException {
        this.buildName(scannable);
        this.buildPassportId(scannable);
        this.buildEyeColor(scannable);
        this.buildHairColor(scannable);
        this.buildNationality(scannable);

        return person;
    }

    /**
     * build name
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildName(Scannable scannable) throws IOException, MyException {

        String name = scannable.readLine();
        try{
            person.setName(name);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * name
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildPassportId(Scannable scannable) throws IOException, MyException {

        String passportId = scannable.readLine();

        try{
            person.setPassportID(passportId);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Eye color
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildEyeColor(Scannable scannable) throws IOException, MyException {

        String eyeColor = scannable.readLine();
        if (eyeColor.isEmpty()){
            person.setEyeColor(null);
            return;
        }

        try{
            person.setEyeColor(Color.valueOf(eyeColor.toUpperCase(Locale.ROOT)));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * hair color
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildHairColor(Scannable scannable) throws IOException, MyException {

        String hairColor = scannable.readLine();
        if (hairColor.isEmpty()){
            person.setHairColor(null);
            return;
        }

        try{
            person.setHairColor(Color.valueOf(hairColor.toUpperCase(Locale.ROOT)));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * nationality
     * @param scannable
     * @throws IOException
     * @throws MyException
     */
    public void buildNationality(Scannable scannable) throws IOException, MyException {

        String nationality = scannable.readLine();
        if (nationality.isEmpty()){
            person.setNationality(null);
            return;
        }

        try{
            person.setNationality(Country.valueOf(nationality.toUpperCase(Locale.ROOT)));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
