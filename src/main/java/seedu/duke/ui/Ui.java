package seedu.duke.ui;

import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.data.student.Student;
import seedu.duke.data.assignment.Answer;
import seedu.duke.data.assignment.Assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The UI class contains methods that deal with the user.
 * UI has methods to read user input and also print output.
 */
public class Ui {
    private final Scanner in;
    private static final String exceptionGreeting = "OOPS!!! ";

    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Prints a horizontal line made of dashes, intending to separate user input and program output.
     */
    public static void showLine() {
        System.out.println("\t---------------------------------------------------------------------");
    }

    /**
     * Prints goodbye message when the user is exiting the program.
     */
    public void showExitMessage() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    /**
     * Prints the ModMan logo and welcomes the user.
     */
    public void showWelcomeMessage() {
        String logo = " __  __           _   __  __\n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__'_| |_|  |_|\\__'_|_| |_|\n";
        System.out.println("Hello from\n" + logo);

    }

    /**
     * Returns String of next line of user's input.
     *
     * @return String of user's input.
     */
    public String readCommand() {
        String fullCommand = in.nextLine();
        return fullCommand;
    }

    /**
     * Prints the error message prepended with an error greeting.
     *
     * @param message String obtained from exception.
     */
    public void showError(String message) {
        System.out.println("\t " + exceptionGreeting + message);
    }

    /**
     * Prints a help message informing the user of basic commands of ModMan.
     */
    public void printHelpMessage() {
        System.out.println("\t Here are the list of basic commands you can use:\n ");
        System.out.println("\t 1. Adding a Module: add module MODULE_NAME\n"
                + "\t 2. Selecting a Module: select MODULE_NAME\n"
                + "\t 3. Viewing Current Module: current\n"
                + "\t 4. Adding a student: add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL\n"
                + "\t 5. Adding a Lesson: add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME\n"
                + "\t 6. Adding an Assignment: add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME\n"
                + "\t 7. Setting Assignment Deadline: set assignment deadline /a ASSIGNMENT_NAME /d DEADLINE\n"
                + "\t 8. Auto-Grading Assignments: autograde /a ASSIGNMENT_NAME\n"
                + "\t 9. Setting Assignment Comments: set assignment comments /a ASSIGNMENT_NAME /c COMMENT\n"
                + "\t 10. Exiting ModMan: bye\n\n"
                + "\t For the full list of commands, check out the User Guide at: "
                + "https://ay2021s2-cs2113t-f08-1.github.io/tp/UserGuide.html");
    }

    /**
     * Prints out message to confirm to the user that the assignment has been added to the respective module.
     *
     * @param module Module object that the user has added assignment to.
     * @param assignment Assignment object that user has added.
     */
    public void printNewAssignment(Module module, Assignment assignment) {
        System.out.println("\t I have added a new assignment to " + module.getModuleCode() + ":");
        System.out.println("\t " + assignment.getName());
    }

    /**
     * Prints out message to confirm to the user that the student has been assigned to the respective module.
     *
     * @param module Module object that the user has assigned student to.
     * @param student Student object that user has added.
     */
    public void printNewStudent(Module module, Student student) {
        System.out.println("\t I have assigned a new student to " + module.getModuleCode() + ":");
        System.out.println("\t " + student);
    }

    /**
     * Prints out message to confirm to the user has changed the name of an assignment in the respective module.
     *
     * @param module Module object that the user has edited assignment name in.
     * @param oldName String specifying the previous name of the assignment.
     * @param newName String specifying the new name of the assignment.
     */
    public void printEditAssignmentName(Module module, String oldName, String newName) {
        System.out.println("\t I have edited your assignment in " + module.getModuleCode() + " from:");
        System.out.println("\t - " + oldName);
        System.out.println("\t to");
        System.out.println("\t + " + newName);
    }

    /**
     * Prints out message to confirm to the user that the module has been added.
     *
     * @param module Module object that user has added.
     */
    public void printNewModule(Module module) {
        System.out.println("\t I have added a new module: " + module.getModuleCode());
    }

    /**
     * Prints out message to confirm to the user that the lesson has been added to the respective module.
     *
     * @param moduleCode String specifying the Module code of the Module that the user has added lesson to.
     * @param lesson Lesson object that user has added.
     */
    public void printNewTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t Success! I have added the following timetable for the module - " + moduleCode);
        System.out.println("\t " + lesson.getLessonType() + ": " + lesson.toString()
                + " (" + lesson.getVenue() + ")");
    }

    /**
     * Prints out all existing assignments in the Module object.
     *
     * @param module Module object.
     */
    public void listModuleAssignments(Module module) {
        ArrayList<Assignment> assignments = module.getAssignments();
        if (assignments.size() == 0) {
            System.out.println("\t You have not added any assignments to " + module.getModuleCode() + " yet.");
        } else {
            assert assignments.size() > 0 : "size of assignments should be greater than zero";
            System.out.println("\t Here are the assignments in " + module.getModuleCode() + ":");
            for (int i = 1; i <= assignments.size(); i++) {
                System.out.println("\t " + i + ". " + assignments.get(i - 1).toString());
            }
        }
    }

    /**
     * Prints out the names of all existing students in the Module object.
     *
     * @param module Module object.
     */
    public void listModuleStudents(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t You have not added any students to " + module.getModuleCode() + " yet.");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            System.out.println("\t Here are the students in " + module.getModuleCode() + ":");
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).getName());
            }
        }
    }

    /**
     * Prints out message to confirm to the user that comment has been added to the assignment in a specific module.
     *
     * @param moduleCode String specifying the Module code of the Module that the assignment is contained in.
     * @param assignmentName String specifying name of the assignment that the comment has been added to.
     * @param comment String of the comment that has been added.
     */
    public void printSetAssignmentComments(String moduleCode, String assignmentName, String comment) {
        System.out.println("\t " + "I have set the following comments to " + assignmentName + ":\n\t\t"
                + comment);
    }

    /**
     * Prints out all existing comments for an assignment.
     *
     * @param assignmentName String specifying name of the assignment.
     * @param comments ArrayList of String containing the comments added to the assignment.
     */
    public void printGetAssignmentComments(String assignmentName, String comments) {
        if (comments == null) {
            System.out.println("\tYou do not have any comments for this assignment previously!");
        } else {
            System.out.println("\t " + "Your previous comments for " + assignmentName + " is as follows:");
            System.out.println("\t\t" + comments);
        }
    }

    /**
     * Prints out the details of all existing students in the Module object.
     *
     * @param module Module object.
     */
    public void listModuleStudentsDetails(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t You have not added any students to " + module.getModuleCode() + " yet.");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            System.out.println("\t Here are the details of all students enrolled in " + module.getModuleCode() + ":");
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).toString());
            }
        }
    }

    /**
     * Prints out the grades of all students for the Assignment object.
     *
     * @param assignment Assignment object.
     */
    public void listAssignmentStudentGrades(Assignment assignment) {
        System.out.println("\t Here are the students' grades for the " + assignment.getName() + " assignment:");
        HashMap<String, Float> studentGrades = assignment.getStudentGrades();
        Iterator it = studentGrades.entrySet().iterator();
        int index = 1;
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println("\t " + index + ". " + pair.getKey() + " - " + pair.getValue());
            index++;
        }
    }

    /**
     * Prints out all existing lessons in the Module object.
     *
     * @param module Module object.
     */
    public void listModuleTimetable(Module module) {
        ArrayList<Lesson> lessons = module.getLessons();
        Lesson lesson;
        if (lessons.size() == 0) {
            System.out.println("\t You have not added any lessons to " + module.getModuleCode() + " yet.");
        } else {
            assert lessons.size() > 0 : "size of lessons should be greater than zero";
            System.out.println("\t Here are the lessons in " + module.getModuleCode() + ":");
            for (int i = 1; i <= lessons.size(); i++) {
                lesson = lessons.get(i - 1);
                System.out.println("\t " + i + ". " + lesson.getLessonType() + ": " + lesson.toString()
                        + " (" + lesson.getVenue() + ")");
            }
        }
    }

    /**
     * Prints out error message to indicate user has tried to reference an assignment that does not exist in the Module.
     *
     * @param assignmentName String specifying name of assignment user has tried to reference.
     * @param moduleCode String specifying the Module code of the Module that the user is working in.
     */
    public void assignmentNotFoundMessage(String assignmentName, String moduleCode) {
        System.out.println("\t " + assignmentName + " not found in " + moduleCode);
    }

    /**
     * Prints out message to confirm to the user that grade has been set for the student,
     * for an assignment, in a specific module.
     *
     * @param moduleCode String specifying the Module code of the Module that the assignment is contained in.
     * @param assignmentName String specifying name of the assignment that the grade has been added to.
     * @param studentName String specifying name of the student.
     * @param grade String specifying grade.
     */
    public void printSetAssignmentGrade(String moduleCode, String assignmentName,
                                        String studentName, String grade) {
        System.out.println("\t " + "I have set " + studentName + "'s grade to " + grade
                + " for assignment " + assignmentName + " in " + moduleCode);
    }

    /**
     * Prints out message to confirm to the user that an assignments weightage has been set, in a specific module.
     *
     * @param moduleCode String specifying the Module code of the Module that the assignment is contained in.
     * @param assignmentName String specifying name of the assignment that the weightage has been set for.
     * @param percentage float value specifying the weightage.
     */
    public void printSetAssignmentPercentage(String moduleCode, String assignmentName, float percentage) {
        System.out.println("\t " + "I have set " + assignmentName + "'s percentage to "
                + percentage + " in " + moduleCode);
    }

    /**
     * Prints out message to confirm to the user that an assignments deadline has been set, in a specific module.
     *
     * @param moduleCode String specifying the Module code of the Module that the assignment is contained in.
     * @param assignmentName String specifying name of the assignment that the deadline has been set for.
     * @param deadline LocalDate object specifying the deadline.
     */
    public void printSetAssignmentDeadline(String moduleCode, String assignmentName, LocalDate deadline) {
        System.out.println("\t " + "I have set " + assignmentName + "'s deadline to "
                + deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " in " + moduleCode);
    }

    /**
     * Prints out message to confirm to the user that they are now working in specified Module.
     *
     * @param moduleCode String specifying the Module code of the Module that the user is working in.
     */
    public void selectModuleMessage(String moduleCode) {
        System.out.println("\t Success! You are now working in: " + moduleCode);
    }

    /**
     * Prints out all existing modules that have been added.
     *
     * @param modules Array List of modules that have been added by the user.
     * @param currentModuleCode String specifying Module code of the Module that the user is currently working in.
     */
    public void printModules(ArrayList<Module> modules, String currentModuleCode) {
        if (modules.size() == 0) {
            System.out.println("\t You have not added any modules to ModMan yet!");
        } else {
            System.out.println("\t Here are your modules: ");
            for (int i = 1; i <= modules.size(); i++) {
                if (currentModuleCode.equals(modules.get(i - 1).getModuleCode())) {
                    System.out.println("\t " + i + ". " + modules.get(i - 1).getModuleCode() + " (current)");
                } else {
                    System.out.println("\t " + i + ". " + modules.get(i - 1).getModuleCode());
                }
            }
        }
    }

    /**
     * Prints out all existing modules that have been added.
     *
     * @param modules Array List of modules that have been added by the user.
     */
    public void printModules(ArrayList<Module> modules) {
        if (modules.size() == 0) {
            System.out.println("\t You have not added any modules to ModMan yet!");
        } else {
            System.out.println("\t Here are your modules: ");
            for (int i = 1; i <= modules.size(); i++) {
                System.out.println("\t " + i + ". " + modules.get(i - 1).getModuleCode());
            }
        }
    }

    /**
     * Prints out message to confirm to the user that the module has been removed.
     *
     * @param moduleCode String specifying Module code of the Module object that user has removed.
     */
    public void removeModuleMessage(String moduleCode) {
        System.out.println("\t You have successfully removed module: " + moduleCode);
    }

    /**
     * Prints out an overview of the module that the user is currently working in.
     *
     * @param module Module object that the user is currently working in.
     */
    public void printModuleInfo(Module module) {
        System.out.println("\t You are currently working in: " + module.getModuleCode());
        System.out.println();
        System.out.println("\t Here's an overview of " +  module.getModuleCode());
        listModuleTimetableOverview(module);
        System.out.println();
        if (module.getStudents().size() == 1) {
            System.out.println("\t\t - You currently have " + module.getStudents().size() + " student in your class");
        } else {
            System.out.println("\t\t - You currently have " + module.getStudents().size() + " students in your class");
        }
        System.out.println();
        listModuleAssignmentsOverview(module);
    }

    /**
     * Prints out an overview of the assignments in the specified module.
     *
     * @param module Module object.
     */
    private void listModuleAssignmentsOverview(Module module) {
        ArrayList<Assignment> assignments = module.getAssignments();
        if (assignments.size() == 0) {
            System.out.println("\t\t - You have not added any assignments to yet.");
        } else {
            assert assignments.size() > 0 : "size of assignments should be greater than zero";
            System.out.println("\t\t - Here are your assignments:");
            for (int i = 1; i <= assignments.size(); i++) {
                System.out.println("\t\t\t - " + assignments.get(i - 1).toString());
            }
        }
    }

    /**
     * Prints out an overview of the lessons in the specified module.
     *
     * @param module Module object.
     */
    private void listModuleTimetableOverview(Module module) {
        ArrayList<Lesson> lessons = module.getLessons();
        Lesson lesson;
        if (lessons.size() == 0) {
            System.out.println("\t\t - You have not added any lessons yet.");
        } else {
            assert lessons.size() > 0 : "size of lessons should be greater than zero";
            System.out.println("\t\t - Here are your lessons: ");
            for (int i = 1; i <= lessons.size(); i++) {
                lesson = lessons.get(i - 1);
                System.out.println("\t\t\t - " + lesson.getLessonType() + ": " + lesson.toString()
                        + " (" + lesson.getVenue() + ")");
            }
        }
    }

    /**
     * Prints out message to confirm to the user that the lesson has been removed from the respective module.
     *
     * @param moduleCode String specifying the Module code of the Module that the user has removed lesson from.
     * @param lesson Lesson object that user has removed.
     */
    public void deleteModuleTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t You have successfully removed lesson: " + lesson.toString() + " from " + moduleCode);
    }

    /**
     * Prints out message to confirm to the user that the lesson has been edited in the respective module.
     *
     * @param moduleCode String specifying the Module code of the Module that the user has edited lesson in.
     * @param lesson Lesson object that user has edited.
     */
    public void editModuleTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t You have successfully edited the lesson to:");
        System.out.println("\t " + lesson.getLessonType() + ": " + lesson.toString()
                + " (" + lesson.getVenue() + ")");
    }

    /**
     * Prints out the answer key for a specified assignment.
     *
     * @param answer Answer object containing the answer key.
     * @param assignmentName String specifying the name of the assignment.
     */
    public void printAnswers(Answer answer, String assignmentName) {
        if (answer.getAnswers().size() == 0) {
            System.out.println("\t Answer key is empty!");
        } else {
            System.out.println("\t Answer key for " + assignmentName);
            for (int i = 1; i <= answer.getAnswers().size(); i++) {
                System.out.println("\t " + i + ". " + answer.getAnswers().get(i - 1) + " | ["
                        + answer.getMarks().get(i - 1) + "]");
            }
        }
    }

    /**
     * Prints out the answer script of a particular student for a specified assignment.
     *
     * @param script Array List of String containing the student's answer script.
     * @param assignmentName String specifying the name of the assignment.
     * @param studentName String specifying the name of the student.
     * @param studentNumber String specifying the student number.
     */
    public void printScript(ArrayList<String> script, String assignmentName, String studentName, String studentNumber) {
        if (script.size() == 0) {
            System.out.println("\t Script is blank!");
        } else {
            System.out.println("\t " + studentName + "(" + studentNumber + ")'s script for " + assignmentName);
            for (int i = 1; i <= script.size(); i++) {
                System.out.println("\t " + i + ". " + script.get(i - 1));
            }
        }
    }

    /**
     * Prints out the list of students whose assignments haven't been submitted.
     *
     * @param ungraded Array List of Student object containing students who haven't submitted their assignments.
     */
    public void listUngradedStudents(ArrayList<Student> ungraded) {
        if (ungraded.size() == 0) {
            System.out.println("\t All scripts have been graded!");
        } else {
            System.out.println("\t These are the students who have not submitted their assignments:");
            for (int i = 1; i <= ungraded.size(); i++) {
                System.out.println("\t " + i + ". " + ungraded.get(i - 1).toString());
            }
        }
    }

    /**
     * Prints out error message to indicate any unrecognised error.
     */
    public void showUnrecognisedError() {
        System.out.println("\t There is an unexpected error.");
    }

    /**
     * Prints out error message to indicate an error while saving user's data to the Database file.
     */
    public void showUnrecognisedSaveError() {
        System.out.println("\t There is an error saving the file.");
    }

    /**
     * Prints out error message to indicate an error while loading data from the Database file.
     */
    public void showUnrecognisedLoadError() {
        System.out.println("\t There is an error loading the file.");
        System.out.println("\t You may have edited Database.txt. Please do not edit Database.txt.");
        System.out.println("\t A new database has been created.");
    }
}
