package сommands;

import collection.MyArrayList;
import convertors.PersonConvertor;
import convertors.ProductConvertor;
import exceptions.MyException;
import io.ServerPrint;
import productclasses.Person;
import productclasses.Product;
import requests.CommandType;
import requests.Request;

public class CommandFactory {
    public static Command buildCommand (Request request, MyArrayList<Product> collection, ServerPrint serverPrint)
            throws MyException {
        CommandType type = request.getType();
        Command command = null;
        switch (type) {
            case ADD: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                command = new AddCommand(collection, product, serverPrint);
                break;
            }
            case ADD_IF_MIN: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                command = new AddIfMinCommand(collection, product, serverPrint);
                break;
            }
            case CLEAR: {
                command = new ClearCommand(collection, serverPrint);
                break;
            }
            case EXECUTE_SCRIPT: {
                command = new ExecuteScriptCommand(collection, request.getCommandInfo()[0], serverPrint);
                break;
            }
            case FILTER_GREATER_THAN_OWNER: {
                Person person = PersonConvertor.convert(request.getCommandInfo()[0]);
                command = new FilterGreaterThanOwnerCommand(person, collection, serverPrint);
                break;
            }
            case EXIT: {
                command = new ExitCommand(serverPrint);
                break;
            }
            case HELP: {
                command = new HelpCommand(serverPrint);
                break;
            }
            case INFO: {
                command = new InfoCommand(collection, serverPrint);
                break;
            }
            case INSERT_AT: {
                Product product = ProductConvertor.convert(request.getCommandInfo()[0]);
                int index = Integer.parseInt(request.getCommandInfo()[1]);
                command = new InsertAtCommand(product, index, collection, serverPrint);
                break;
            }
            case MAX_BY_UNIT_OF_MEASURE: {
                command = new MaxByUnitOfMeasureCommand(collection, serverPrint);
                break;
            }
            case REMOVE_ALL_BY_OWNER: {
                Person person = PersonConvertor.convert(request.getCommandInfo()[0]);
                command = new RemoveAllByOwnerCommand(collection, person, serverPrint);
                break;
            }
            case REMOVE_BY_ID: {
                long id = Long.parseLong(request.getCommandInfo()[0]);
                command = new RemoveByIdCommand(collection, id, serverPrint);
                break;
            }
            case SAVE: {
                command = new SaveCommand(collection, serverPrint);
                break;
            }
            case SHOW: {
                command = new ShowCommand(collection, serverPrint);
                break;
            }
            case SORT: {
                command = new SortCommand(collection, serverPrint);
                break;
            }
            case UPDATE: {
                long id = Long.parseLong(request.getCommandInfo()[0]);
                Product product = ProductConvertor.convert(request.getCommandInfo()[1]);
                command = new UpdateCommand(collection, id, product, serverPrint);
                break;
            }
        }
        return command;
    }
}
