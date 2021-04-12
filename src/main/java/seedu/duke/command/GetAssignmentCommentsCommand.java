package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;
import seedu.duke.exception.ModuleNotSelectedException;

public class GetAssignmentCommentsCommand extends Command {
    private String moduleCode;
    private String assignmentName;

    /**
     * Constructor for GetAssignmentCommentsCommand Class.
     *
     * @param moduleCode current module.
     * @param assignmentName String specifying assignment name.
     * @throws ModuleNotSelectedException Thrown when user is not currently working in any module.
     */
    public GetAssignmentCommentsCommand(String moduleCode, String assignmentName) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
    }

    /**
     * Prints out list of comments for a specific assignment.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     * @throws ModuleNotFoundException Thrown when module is not found.
     * @throws AssignmentNotFoundException Thrown when assignment is not found.
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, AssignmentNotFoundException {
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
        String comments = assignment.getComments();
        ui.printGetAssignmentComments(assignmentName, comments);
    }
}
