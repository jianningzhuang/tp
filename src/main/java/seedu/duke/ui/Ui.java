package seedu.duke.ui;

import seedu.duke.Assignment;
import seedu.duke.Module;

import java.util.Scanner;


public class Ui {
    private final Scanner in;
    private static final String exceptionGreeting = "OOPS!!! ";

    public Ui() {
        in = new Scanner(System.in);
    }

    public static void showLine() {
        System.out.println("\t---------------------------------------------------------------------");
    }

    public void showExitMessage() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    public void showWelcomeMessage() {
        String logo = " __  __           _   __  __\n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__'_| |_|  |_|\\__'_|_| |_|\n";
        System.out.println("Hello from\n" + logo);
    }

    public String readCommand() {
        String fullCommand = in.nextLine();
        return fullCommand;
    }

    public void showError(String message) {
        System.out.println("\t" + exceptionGreeting + message);
    }

    public void printNewAssignment(Module module, Assignment assignment) {
        System.out.println("\t I have added a new assignment to " + module.getModuleCode() + ":");
        System.out.println("\t + " + assignment);
    }

    public void printNewModule(Module module) {
        System.out.println("\t I have added a new module: " + module.getModuleCode());
    }
}