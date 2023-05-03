package commands;


import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;


public class SummOfPrice extends AbstractCommand{
    private CollectionManager collectionManager;

    public SummOfPrice(CollectionManager collectionManager) {
        super("summ", "выводит сумму цен всех продуктов");
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
            System.out.println(collectionManager.getSumOfPrice());
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование не удалось: '" + getName() + "'");
        }
        return false;
    }

}
