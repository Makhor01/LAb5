package commands;


import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;


public class CountGreaterThan extends AbstractCommand{
    private CollectionManager collectionManager;

    public CountGreaterThan(CollectionManager collectionManager) {
        super("count_greater_than_unit_of_measure", "выводит количества всех продуктов, чья единица измерения больше заданного");
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
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.countGreaterThan(argument);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
