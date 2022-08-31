package utils;


import collection.MyArrayList;
import productclasses.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CSV manager
 */
public class CSVManager {

    /**
     * convert collection to csv
     * @param myArrayList collection
     * @param delimiter delimiter
     * @return csv string
     */
    public static String toCSV(MyArrayList<Product> myArrayList, char delimiter){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(myArrayList.getCreationDate().toString()).append("\n");

        myArrayList.forEach(product -> {
            stringBuilder.append(product.getId()).append(delimiter);
            stringBuilder.append(product.getName().toString()).append(delimiter);

            Coordinates coordinates = product.getCoordinates();
            stringBuilder.append(coordinates.getX().toString()).append(delimiter).append(coordinates.getY()).append(delimiter);
            stringBuilder.append(product.getCreationDate().toString()).append(delimiter);
            stringBuilder.append(product.getPrice().toString()).append(delimiter);
            stringBuilder.append(product.getUnitOfMeasure()).append(delimiter);

            Person person = product.getOwner();
            stringBuilder.append(person.getName()).append(delimiter);
            stringBuilder.append(person.getPassportID().toString()).append(delimiter);

            if (person.getEyeColor() != null)
                stringBuilder.append(person.getEyeColor().toString());
            stringBuilder.append(delimiter);

            if (person.getHairColor() != null)
                stringBuilder.append(person.getEyeColor().toString());
            stringBuilder.append(delimiter);

            if (person.getNationality() != null)
                stringBuilder.append(person.getNationality().toString());
//            stringBuilder.append(delimiter);

            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    /**
     * convert csv to collection
     * @param csvString csv string
     * @param delimiter delimiter
     * @return collection
     */
    public static MyArrayList<Product> toMyArrayList(String csvString, char delimiter){
        MyArrayList<Product> myArrayList = new MyArrayList<>();

        List<String> lines = new ArrayList<>(Arrays.asList(csvString.split("\n")));
        myArrayList.setCreationDate(ZonedDateTime.parse(lines.get(0)));
        lines.removeIf(String::isEmpty);
        lines.remove(0);

        lines.forEach(line -> {
            Product product = new Product();
            String[] fields = line.split(String.valueOf(delimiter));
            int index = 0;
            try {
                product.setId(Long.parseLong(fields[index++]));
                product.setName(fields[index++]);

                Coordinates coordinates = new Coordinates();
                coordinates.setX(Float.valueOf(fields[index++]));
                coordinates.setY(Integer.valueOf(fields[index++]));
                product.setCoordinates(coordinates);

                product.setCreationDate(ZonedDateTime.parse(fields[index++]));
                product.setPrice(Integer.valueOf(fields[index++]));
                product.setUnitOfMeasure(UnitOfMeasure.valueOf(fields[index++]));

                Person person = new Person();
                person.setName(fields[index++]);
                person.setPassportID(fields[index++]);

                if (!fields[index].isEmpty()){
                    person.setEyeColor(Color.valueOf(fields[index]));
                } else {
                    person.setEyeColor(null);
                }
                ++index;

                if (!fields[index].isEmpty()){
                    person.setHairColor(Color.valueOf(fields[index]));
                } else {
                    person.setHairColor(null);
                }
                ++index;

                if (!fields[index].isEmpty()){
                    person.setNationality(Country.valueOf(fields[index]));
                } else {
                    person.setNationality(null);
                }

                product.setOwner(person);
                myArrayList.add(product);

            } catch (Exception e){
            }
        });

        return myArrayList;
    }
}
