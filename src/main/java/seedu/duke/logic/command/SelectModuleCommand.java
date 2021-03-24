package seedu.duke.logic.command;

import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;


public class SelectModuleCommand extends Command {
    public String moduleCode;

    public SelectModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
        assert this.moduleCode != null : "Module code cannot be null";
    }

    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        if (data.find(moduleCode) == null) {
            throw new ModuleNotFoundException();
        } else {
            Parser.setCurrentModule(moduleCode);
            ui.selectModuleMessage(moduleCode);
        }
    }
}