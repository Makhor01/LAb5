package commands;

import collectionClases.*;

import exceptions.CollectionIsEmptyException;
import exceptions.ProductNotFoundException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;

import utility.CollectionManager;
import utility.Console;
import utility.ProductAsk;


/**
 * Command 'update'. Updates the information about selected group.
 */

public class UpdateCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private ProductAsk productAsk;

    public UpdateCommand(CollectionManager collectionManager, ProductAsk productAsk) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
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
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            int id = Integer.parseInt(argument);
            Product previousProduct = collectionManager.getById(id);
            if (previousProduct == null) throw new ProductNotFoundException();

            String name = previousProduct.getName();
            Coordinates coordinates = previousProduct.getCoordinates();
            double price = previousProduct.getPrice();
            UnitOfMeasure unit = previousProduct.getUnitOfMeasure();
            String orgName = previousProduct.getManufacturer().getName();
            String fullName = previousProduct.getManufacturer().getFullName();
            OrganizationType type = previousProduct.getManufacturer().getType();
            Address address = previousProduct.getManufacturer().getPostalAddress();

            collectionManager.removeFromCollection(previousProduct);

            if (productAsk.askQuestion("Хотите изменить имя рподукта?")) name = productAsk.askName();
            if (productAsk.askQuestion("Хотите изменить координаты продукта?")) coordinates = productAsk.askCoordinate();
            if (productAsk.askQuestion("Хотите изменить цену продукта?")) price = productAsk.askPrice();
            if (productAsk.askQuestion("Хотите изменить еденицы измерения продукта?")) unit = productAsk.askUnitOfMeasure();
            if (productAsk.askQuestion("Хотите изменить имя организации?")) orgName = productAsk.askOrganizationName();
            if (productAsk.askQuestion("Хотите изменить полное имя организации?")) fullName = productAsk.askOrganizationShortname();
            if (productAsk.askQuestion("Хотите изменить тип организации?")) type = productAsk.askOrganozationType();
            if (productAsk.askQuestion("Хотите изменить адресс организации?")) address = productAsk.askAdress();
            collectionManager.addToCollection(new Product(
                    name,
                    coordinates,
                    price,
                    unit,
                    new Organization(1L,name,fullName,type,address)
            ));
            Console.println("Product успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (ProductNotFoundException exception) {
            Console.printerror("Product с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
