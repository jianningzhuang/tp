package seedu.duke;

import seedu.duke.logic.command.Command;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

public class Modman {

    private Data data;
    private Ui ui;

    public Modman() {
        ui = new Ui();
        data = new Data();
    }

    public void run() {
        ui.showWelcomeMessage();
        ui.printModules(data.getModules());
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(data, ui);
                isExit = c.isExit();
            } catch (ModManException e) {
                ui.showError(e.getErrorMessage());
            } finally {
                Ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Modman().run();
    }
}
