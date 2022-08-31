package service;

import exceptions.MyException;
import io.Printable;
import io.Scannable;
import productclasses.builders.PersonStringBuilder;
import productclasses.builders.ProductStringBuilder;
import requests.CommandType;
import requests.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * class for making requests for server
 */
public class RequestManager {

    /**
     * creating a requests
     * @param scannable
     * @param printable
     * @param isConsole - is console input
     * @return
     * @throws IOException
     * @throws MyException
     */
    public static Request getRequest(Scannable scannable, Printable printable, boolean isConsole)
            throws IOException, MyException {

        if (isConsole){
            printable.println("Enter the command: ");
        }
        String commandLine = scannable.readLine();
        List<String> words = getWords(commandLine);
        if (words.isEmpty()){
            throw new MyException("There is no command");
        }

        String commandName = words.get(0);
        String[] args;

        switch (commandName.toLowerCase(Locale.ROOT)){
            case "info":{
                return new Request(CommandType.INFO, null);
            }
            case "help":{
                return new Request(CommandType.HELP, null);
            }
            case "show":{
                return new Request(CommandType.SHOW, null);
            }
            case "exit":{
                return new Request(CommandType.EXIT, null);
            }
            case "add":{
                ProductStringBuilder productBuilder = new ProductStringBuilder(isConsole);
                String product = productBuilder.build(scannable, printable, ',');
                args = new String[] { product };
                return new Request(CommandType.ADD, args);
            }
            case "clear":{
                return new Request(CommandType.CLEAR, null);
            }
            case "remove_by_id":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                args = new String[] { words.get(1) };
                return new Request(CommandType.REMOVE_BY_ID, args);
            }
            case "sort":{
                return new Request(CommandType.SORT, null);
            }
            case "filter_greater_than_owner":{
                PersonStringBuilder personBuilder = new PersonStringBuilder(isConsole);
                String person = personBuilder.build(scannable, printable, ';');
                args = new String[]{ person };
                return new Request(CommandType.FILTER_GREATER_THAN_OWNER, args);
            }
            case "save":{
                return new Request(CommandType.SAVE, null);
            }
            case "insert_at":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                int index = Integer.parseInt(words.get(1));
                ProductStringBuilder productBuilder = new ProductStringBuilder(isConsole);
                String product = productBuilder.build(scannable, printable, ',');
                args = new String[] { product, Integer.toString(index) };
                return new Request(CommandType.INSERT_AT, args);
            }
            case "update":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                long id = Long.parseLong(words.get(1));
                ProductStringBuilder productBuilder = new ProductStringBuilder(isConsole);
                String product = productBuilder.build(scannable, printable, ',');
                args = new String[] { Long.toString(id),  product };
                return new Request(CommandType.UPDATE, args);
            }
            case "add_if_min":{
                ProductStringBuilder productBuilder = new ProductStringBuilder(isConsole);
                String product = productBuilder.build(scannable, printable, ',');
                args = new String[] { product };
                return new Request(CommandType.ADD_IF_MIN, args);
            }
            case "remove_all_by_owner":{
                PersonStringBuilder personBuilder = new PersonStringBuilder(isConsole);
                String owner = personBuilder.build(scannable, printable, ';');
                args = new String[] { owner };
                return new Request(CommandType.REMOVE_ALL_BY_OWNER, args);
            }
            case "max_by_unit_of_measure":{
                return new Request(CommandType.MAX_BY_UNIT_OF_MEASURE, null);
            }
            case "execute_script":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                args = new String[] { words.get(1) };
                return new Request(CommandType.EXECUTE_SCRIPT, args);
            }
            default:
                throw new MyException("No such command");
        }
    }

    /**
     * @param line get words from commands
     * @return
     */
    private static List<String> getWords(String line){
        List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
        words.removeIf(String::isEmpty);

        return words;
    }
}
