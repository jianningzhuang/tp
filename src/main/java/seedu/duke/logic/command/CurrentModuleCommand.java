package seedu.duke.logic.command;

import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

public class CurrentModuleCommand extends Command {
    public String moduleCode;
    
    public CurrentModuleCommand() {
        moduleCode = Parser.getCurrentModule();
        assert this.moduleCode != null : "Module code cannot be null";
    }

    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        if (moduleCode.equals("null")) {
            ui.printModuleInfo();
        } else {
            Module currentModule = data.find(moduleCode);
            ui.printModuleInfo(currentModule);
        }
    }
}
