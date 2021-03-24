package seedu.duke.logic.command;

import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {
        this.setExit();
    }

    public void execute(Data data, Ui ui) {
        ui.showExitMessage();
    }

}