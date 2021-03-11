package seedu.duke.command;


import seedu.duke.data.Data;
import seedu.duke.Module;
import seedu.duke.ui.Ui;

public class AddModuleCommand extends Command {
    public String moduleCode;

    public AddModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui) {
        Module module = new Module(moduleCode);
        data.add(module);
        ui.printNewModule(module);
    }
}
