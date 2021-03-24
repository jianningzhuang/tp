package seedu.duke.logic.command;

import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

public class SortAssignmentByDeadlineCommand extends Command {
    private String moduleCode;

    public SortAssignmentByDeadlineCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        module.sortAssignments();
        ui.listModuleAssignments(module);
    }
}
