package seedu.duke.command;

import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public abstract class Command {

    private boolean isExit = false;

    public abstract void execute(Data data, Ui ui);

    public boolean isExit() {
        return isExit;
    }

    public void setExit() {
        this.isExit = true;
    }

}
