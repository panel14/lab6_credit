package сommands;

import collection.MyArrayList;
import convertors.PersonConvertor;
import convertors.ProductConvertor;
import exceptions.MyException;
import productclasses.Person;
import productclasses.Product;
import requests.CommandType;
import requests.Request;

/**
 * class-factory for building commands from a clients requests
 */
public class CommandFactory {
    /**
     * build a command
     * @param request
     * @param collection
     * @return
     * @throws MyException
     */
    public static Command buildCommand (Request request, MyArrayList<Product> collection)
            throws MyException {
        CommandType type = request.getType();
        Command command = null;
        switch (type) {
            case ADD: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                command = new AddCommand(collection, product);
                break;
            }
            case ADD_IF_MIN: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                command = new AddIfMinCommand(collection, product);
                break;
            }
            case CLEAR: {
                command = new ClearCommand(collection);
                break;
            }
            case EXECUTE_SCRIPT: {
                command = new ExecuteScriptCommand(collection, request.getCommandInfo()[0]);
                break;
            }
            case FILTER_GREATER_THAN_OWNER: {
                Person person = PersonConvertor.convert(request.getCommandInfo()[0]);
                command = new FilterGreaterThanOwnerCommand(person, collection);
                break;
            }
            case EXIT: {
                command = new ExitCommand();
                break;
            }
            case HELP: {
                command = new HelpCommand();
                break;
            }
            case INFO: {
                command = new InfoCommand(collection);
                break;
            }
            case INSERT_AT: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                int index = Integer.parseInt(request.getCommandInfo()[1]);
                command = new InsertAtCommand(product, index, collection);
                break;
            }
            case MAX_BY_UNIT_OF_MEASURE: {
                command = new MaxByUnitOfMeasureCommand(collection);
                break;
            }
            case REMOVE_ALL_BY_OWNER: {
                Person person = PersonConvertor.convert(request.getCommandInfo()[0]);
                command = new RemoveAllByOwnerCommand(collection, person);
                break;
            }
            case REMOVE_BY_ID: {
                long id = Long.parseLong(request.getCommandInfo()[0]);
                command = new RemoveByIdCommand(collection, id);
                break;
            }
            case SAVE: {
                command = new SaveCommand(collection);
                break;
            }
            case SHOW: {
                command = new ShowCommand(collection);
                break;
            }
            case SORT: {
                command = new SortCommand(collection);
                break;
            }
            case UPDATE: {
                long id = Long.parseLong(request.getCommandInfo()[0]);
                Product product = ProductConvertor.convert(request.getCommandInfo()[1]);
                command = new UpdateCommand(collection, id, product);
                break;
            }
        }
        return command;
    }
}
