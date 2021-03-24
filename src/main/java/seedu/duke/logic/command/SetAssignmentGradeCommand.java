package seedu.duke.logic.command;

import seedu.duke.assignment.Assignment;
import seedu.duke.Module;
import seedu.duke.Student;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class SetAssignmentGradeCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String studentName;
    public String grade;

    public SetAssignmentGradeCommand(String moduleCode, String assignmentName,
                                     String studentName, String grade) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.studentName = studentName;
        this.grade = grade;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        Student student = module.findStudent(studentName);
        Assignment assignment = module.findAssignment(assignmentName);
        assignment.setStudentGrade(student, grade);
        ui.printSetAssignmentGrade(moduleCode, assignmentName, studentName, grade);
    }
}
