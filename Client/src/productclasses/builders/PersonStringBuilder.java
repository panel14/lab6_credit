package productclasses.builders;

import exceptions.MyException;
import io.Printable;
import io.Scannable;
import productclasses.enums.Color;
import productclasses.enums.Country;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * class for building person string
 */
public class PersonStringBuilder {
    /**
     * isConsole
     */
    private boolean isConsole;

    /**
     * constructor
     * @param isConsole
     */
    public PersonStringBuilder(boolean isConsole) {
        this.isConsole = isConsole;
    }

    /**
     * main method for build person string
     * @param scannable
     * @param printable
     * @return
     * @throws MyException
     * @throws IOException
     */
    public String build(Scannable scannable, Printable printable, char delimiter) throws MyException, IOException {

        return buildName(scannable, printable) + delimiter +
                buildPassportId(scannable, printable) + delimiter +
                buildEyeColor(scannable, printable) + delimiter +
                buildHairColor(scannable, printable) + delimiter +
                buildNationality(scannable, printable);
    }

    /**
     * build name
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildName(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            while (true){
                printable.println("Enter owner name: ");
                String name = scannable.readLine();

                if (name == null || name.isEmpty()) {
                    printable.println("name can't be empty");
                    continue;
                }
                return name;
            }
        }
        return scannable.readLine();
    }

    /**
     * passportId
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildPassportId(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            while (true){
                printable.println("Enter the passportId: ");
                String passportId = scannable.readLine();
                if (passportId == null) {
                    printable.println("passportID can't be null");
                    continue;
                }
                return passportId;
            }
        }
        return scannable.readLine();
    }

    /**
     * Eye color
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildEyeColor(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            printable.println("Enter the eyeColor " + Arrays.toString(Color.values()) + ": ");
            String eyeColor = scannable.readLine();
            while (true) {
                if (eyeColor.isEmpty())
                    return "#";
                try{
                    Color testColor = (Color.valueOf(eyeColor.toUpperCase(Locale.ROOT)));
                } catch (Exception e){
                    printable.println("Error: " + e.getMessage());
                    continue;
                }

                return eyeColor;
            }
        }

        String eyeColor = scannable.readLine();
        if (eyeColor.isEmpty())
            return "#";
        return eyeColor;
    }

    /**
     * hair color
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildHairColor(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            while (true){
                printable.println("Enter the hairColor " + Arrays.toString(Color.values()) + ": ");
                String hairColor = scannable.readLine();
                if (hairColor.isEmpty())
                    return "#";
                try{
                    Color testColor = Color.valueOf(hairColor.toUpperCase(Locale.ROOT));
                } catch (Exception e){
                    printable.println("Error: " + e.getMessage());
                    continue;
                }

                return hairColor;
            }
        }

        String hairColor = scannable.readLine();
        if (hairColor.isEmpty())
            return "#";
        return hairColor;
    }

    /**
     * nationality
     * @param scannable
     * @param printable
     * @throws IOException
     * @throws MyException
     */
    public String buildNationality(Scannable scannable, Printable printable) throws IOException, MyException {
        if (isConsole){
            while (true){
                printable.println("Enter the nationality " + Arrays.toString(Country.values()) + ": ");
                String nationality = scannable.readLine();
                if (nationality.isEmpty()){
                    return "#";
                }

                try{
                    Country testCountry = Country.valueOf(nationality.toUpperCase(Locale.ROOT));
                } catch (Exception e){
                    printable.println("Error: " + e.getMessage());
                    continue;
                }

                return nationality;
            }
        }

        String nationality = scannable.readLine();
        if (nationality.isEmpty()){
            return "#";
        }

        return nationality;
    }
}
