package utils;

import collection.MyArrayList;
import exceptions.MyException;
import io.Scannable;
import io.ServerPrint;
import productclasses.Person;
import productclasses.Product;
import productclasses.builders.PersonBuilder;
import productclasses.builders.ProductBuilder;
import сommands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Class for manage commands
 */
public class CommandManager {
    /**
     * local collection
     */
    private MyArrayList<Product> myArrayList;

    /**
     * @param myArrayList constructor with collection
     */
    public CommandManager(MyArrayList<Product> myArrayList) {
        this.myArrayList = myArrayList;
    }

    /**
     * @param line get words from commands
     * @return
     */
    private List<String> getWords(String line){
        List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
        words.removeIf(String::isEmpty);

        return words;
    }

    /**
     * do the command
     * @param scannable scannable
     * @return command result
     * @throws IOException
     * @throws MyException
     */
    public Command getCommand(Scannable scannable, ServerPrint serverPrint) throws IOException, MyException {
        String commandLine = scannable.readLine();
        List<String> words = getWords(commandLine);
        if (words.isEmpty()){
            throw new MyException("There is no command");
        }

        String commandName = words.get(0);

        switch (commandName.toLowerCase(Locale.ROOT)){
            case "info":{
                return new InfoCommand(myArrayList, serverPrint);
            }
            case "help":{
                return new HelpCommand(serverPrint);
            }
            case "show":{
                return new ShowCommand(myArrayList, serverPrint);
            }
            case "exit":{
                return new ExitCommand(serverPrint);
            }
            case "add":{
                ProductBuilder productBuilder = new ProductBuilder();
                Product product = productBuilder.build(scannable);
                return new AddCommand(myArrayList, product, serverPrint);
            }
            case "clear":{
                return new ClearCommand(myArrayList, serverPrint);
            }
            case "remove_by_id":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                return new RemoveByIdCommand(myArrayList, Long.parseLong(words.get(1)), serverPrint);
            }
            case "sort":{
                return new SortCommand(myArrayList, serverPrint);
            }
            case "filter_greater_than_owner":{
                PersonBuilder personBuilder = new PersonBuilder();
                Person person = personBuilder.build(scannable);
                return new FilterGreaterThanOwnerCommand(person, myArrayList, serverPrint);
            }
            case "save":{
                return new SaveCommand(myArrayList, serverPrint);
            }
            case "insert_at":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                int index = Integer.parseInt(words.get(1));
                ProductBuilder productBuilder = new ProductBuilder();
                Product product = productBuilder.build(scannable);
                return new InsertAtCommand(product, index, myArrayList, serverPrint);
            }
            case "update":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                long id = Long.parseLong(words.get(1));
                ProductBuilder productBuilder = new ProductBuilder();
                Product product = productBuilder.build(scannable);
                return new UpdateCommand(myArrayList, id, product, serverPrint);
            }
            case "add_if_min":{
                ProductBuilder productBuilder = new ProductBuilder();
                Product product = productBuilder.build(scannable);
                return new AddIfMinCommand(myArrayList, product, serverPrint);
            }
            case "remove_all_by_owner":{
                PersonBuilder personBuilder = new PersonBuilder();
                Person owner = personBuilder.build(scannable);
                return new RemoveAllByOwnerCommand(myArrayList, owner, serverPrint);
            }
            case "max_by_unit_of_measure":{
                return new MaxByUnitOfMeasureCommand(myArrayList, serverPrint);
            }
            case "execute_script":{
                if (words.size() < 2){
                    throw new MyException("Not enough arguments");
                }
                return new ExecuteScriptCommand(myArrayList, words.get(1), serverPrint);
            }
            default:
                throw new MyException("No such command");
        }
    }
}
