package runApplication;


import commands.*;
import utility.*;
import utility.Console;

import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program. inicializates main classes
 *
 * @author Khoroshev Maxim
 */


public class App {
    public static final String PS1 = "cmd - ";

    public static final String PS2 = "ref>-  ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)){
            final String envVariable = "LABA";

            ProductAsk groupAsker = new ProductAsk(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(

                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new InsertCommand(collectionManager, groupAsker),
                    new UpdateCommand(collectionManager, groupAsker),
                    new RemoveLower(collectionManager),
                    new RemoveGreater(collectionManager),
                    new RemoveKey(collectionManager),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptCommand(),
                    new RemoveKey(collectionManager),
                    new SortCommand(collectionManager),
                    new HistoryCommand(),
                    //new SumOfTransferredStudentsCommand(collectionManager),
                    new MinById(collectionManager),
                    new CountGreaterThan(collectionManager),
                    new SummOfPrice(collectionManager)
            );
            Console console = new Console(commandManager,userScanner, groupAsker);

            console.interactiveMode();

        }
    }
}
