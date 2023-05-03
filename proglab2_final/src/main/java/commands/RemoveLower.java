package commands;

import collectionClases.Product;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

import java.util.ArrayList;


/**
 * Command 'remove_by_id'. Removes the elements lower price.
 */

public class RemoveLower extends AbstractCommand{
    private CollectionManager collectionManager;

    public RemoveLower(CollectionManager collectionManager) {
        super("remove_lower price", "удалить элемент из коллекции меньше по price");
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
            Double price = Double.parseDouble(argument);
            ArrayList<Integer> keys= new ArrayList<>();
            for (Product product: collectionManager.getCollection().values()) {
                if (product.getPrice()<price)
                {
                    keys.add(product.getId());
                };

            }
            for (Integer index: keys) {
                collectionManager.removeFromCollection(collectionManager.getById(index));
            }
            Console.println("Продукты успешно удалены!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("Price должен быть представлен числом!");
        }
        return false;
    }
}
