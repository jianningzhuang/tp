package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.exception.CommentsTooLongException;
import seedu.duke.ui.Ui;

public class SetAssignmentCommentsCommand extends Command {
    private String moduleCode;
    private String assignmentName;
    private String comments;

    /**
     * Constructor for SetAssignmentCommentsCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignemnt
     * @param comments comments for the assignment
     * @throws ModuleNotSelectedException not working in any module
     * @throws EmptyParameterException insufficient parameters
     */
    public SetAssignmentCommentsCommand(String moduleCode, String assignmentName, String comments)
            throws ModuleNotSelectedException, EmptyParameterException, CommentsTooLongException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        this.comments = comments.trim();
        if (comments.length() == 0) {
            throw new EmptyParameterException();
        }
        if (comments.length() > 100) {
            throw new CommentsTooLongException();
        }
    }

    /**
     * Sets the comments for the assignment.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModManException general exception
     */
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
        assignment.setComments(comments);
        ui.printSetAssignmentComments(moduleCode, assignmentName, comments);
    }
}
