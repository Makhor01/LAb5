package commands;


import collectionClases.Product;
import exceptions.CollectionIsEmptyException;
import exceptions.ProductNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

/**
 * Command 'remove_key'. Removes the element by index.
 */
public class RemoveKey extends AbstractCommand{
    private CollectionManager collectionManager;

    public RemoveKey(CollectionManager collectionManager) {
        super("remove_key", "удалить элемент из коллекции по key");
        this.collectionManager = collectionManager;
    }


    @Override
    public String getDescription() {
        return null;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            int index = Integer.parseInt(argument);
            Product productToRemove = collectionManager.getById(index);
            if (productToRemove == null) throw new ProductNotFoundException();
            collectionManager.removeFromCollection(productToRemove);
            Console.println("Product успешно удален!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("Index должен быть представлен числом!");
        } catch (ProductNotFoundException exception) {
            Console.printerror("Product с таким ID в коллекции нет!");
        }
        return false;
    }
}

