package seedu.duke;

import java.util.ArrayList;

public class Module {
    private String moduleCode;
    private ArrayList<Assignment> assignments;

    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.assignments = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void printAssignments() {
        System.out.println("Here are your assignments for " + moduleCode + ":");
        for (Assignment a: assignments) {
            System.out.println(a);
        }
    }
}
