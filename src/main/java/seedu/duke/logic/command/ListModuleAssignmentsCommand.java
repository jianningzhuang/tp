package seedu.duke.logic.command;

import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;


public class ListModuleAssignmentsCommand extends Command {

    private String moduleCode;

    public ListModuleAssignmentsCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        ui.listModuleAssignments(module);
    }
}
