package convertors;

import exceptions.MyException;
import productclasses.Color;
import productclasses.Country;
import productclasses.Person;

import java.util.Locale;

/**
 * class for converting person-string to person class
 */
public class PersonConvertor {
    public static Person convert(String string) throws MyException {
        String[] args = string.split(";");

        Person person = new Person();
        person.setName(args[0]);
        person.setPassportID(args[1]);

        if (args[2].equals("#"))
            person.setEyeColor(null);
        else
            person.setEyeColor(Color.valueOf(args[2].toUpperCase(Locale.ROOT)));

        if (args[3].equals("#"))
            person.setEyeColor(null);
        else
            person.setHairColor(Color.valueOf(args[3].toUpperCase(Locale.ROOT)));

        if (args[4].equals("#"))
            person.setNationality(null);
        else
            person.setNationality(Country.valueOf(args[4].toUpperCase(Locale.ROOT)));

        return person;
    }
}
