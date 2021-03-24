package seedu.duke.logic.command;

import seedu.duke.Module;
import seedu.duke.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class EditAssignmentNameCommand extends Command {
    private final String moduleCode;
    private final String oldName;
    private final String newName;

    public EditAssignmentNameCommand(String moduleCode, String oldName, String newName) {
        this.moduleCode = moduleCode;
        this.oldName = oldName;
        this.newName = newName;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        Assignment assignmentToBeEdited = null;
        for (Assignment assignment : module.getAssignments()) {
            if (assignment.getName().equals(oldName)) {
                assignmentToBeEdited = assignment;
            }
        }
        assignmentToBeEdited.setName(newName);
        ui.printEditAssignment(module, oldName, newName);
    }
}
