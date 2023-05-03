package commands;

import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;

import utility.CollectionManager;
import utility.Console;

import utility.ProductAsk;

/**
 * Command 'add'. Adds a new element to collection.
 */

public class InsertCommand extends AbstractCommand {

    private CollectionManager collectionManager;

    private ProductAsk productAsk;

    public InsertCommand(CollectionManager collectionManager, ProductAsk productAsk) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.productAsk = productAsk;
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
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(productAsk.askProduct());
            Console.println("Продукт успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
