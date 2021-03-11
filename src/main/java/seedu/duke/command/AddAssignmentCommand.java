package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class AddAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;

    public AddAssignmentCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        Assignment assignment = new Assignment(assignmentName);
        module.addAssignment(assignment);
        ui.printNewAssignment(module, assignment);
    }
}
