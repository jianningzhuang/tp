package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class GetAssignmentCommentsCommand extends Command {
    private String moduleCode;
    private String assignmentName;

    public GetAssignmentCommentsCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModManException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "module should not be null";
        ArrayList<String> comments = assignment.getComments();
        ui.printGetAssignmentComments(assignmentName, comments);
    }
}
