package seedu.duke.logic.command;

import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListModuleCommand extends Command {

    public ListModuleCommand() {
    }

    public void execute(Data data, Ui ui) {
        ArrayList<Module> modules = data.getModules();
        ui.printModules(modules);
    }
}