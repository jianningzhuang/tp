package seedu.duke.logic.command;

import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

public abstract class Command {

    private boolean isExit = false;

    public abstract void execute(Data data, Ui ui) throws ModManException;

    public boolean isExit() {
        return isExit;
    }

    public void setExit() {
        this.isExit = true;
    }

}
