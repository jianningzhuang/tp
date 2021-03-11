package seedu.duke.parser;

import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

public class Parser {

    public static Command parse(String line) throws ModManException {
        Command command = null;
        String[] words = line.split(" ");
        switch (words[0]) {
        case "bye":
            command = new ExitCommand();
            break;
        case "addmodule":
            command = new AddModuleCommand(words[1]);
            break;
        case "addassignment":
            command = new AddAssignmentCommand(words[1], words[2]);
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}
