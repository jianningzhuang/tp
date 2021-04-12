package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.data.module.Module;
import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListModuleAssignmentsCommand;
import seedu.duke.command.SetAssignmentDeadlineCommand;
import seedu.duke.exception.DateTimeFormatException;
import seedu.duke.exception.InsufficientParametersException;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParserTest {

    @Test
    void testParse_bye_ExitCommand() throws ModManException {
        String inputString = "bye";
        Command c = Parser.parse(inputString);
        assertTrue(c instanceof ExitCommand);
    }


    @Test
    void testParse_addModuleValid_AddModuleCommand() throws ModManException {
        String inputString = "add module CS2113T";
        Command c = Parser.parse(inputString);
        assertTrue(c instanceof AddModuleCommand);
    }

    @Test
    void testParse_addModuleNoModuleCode_InsufficientParametersException() {
        String inputString = "add module ";
        assertThrows(InsufficientParametersException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_addAssignmentValid_AddAssignmentCommand() throws ModManException {
        String inputString = "add assignment /t la /a quiz1";
        Command c = Parser.parse(inputString);
        assertTrue(c instanceof AddAssignmentCommand);
    }

    @Test
    void testParse_addAssignmentMissingParam_InsufficientParametersException() {
        String inputString = "add assignment ";
        assertThrows(InsufficientParametersException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_addAssignmentEmptyAssignment_InsufficientParametersException() {
        String inputString = "add assignment /a     ";
        assertThrows(InsufficientParametersException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_listAssignmentValid_ListModuleAssignmentsCommand() throws ModManException {
        Module testModule = new Module("CS2113T");
        Parser.setCurrentModule(testModule.getModuleCode());
        String inputString = "list assignments";
        Command c = Parser.parse(inputString);
        assertTrue(c instanceof ListModuleAssignmentsCommand);
    }

    @Test
    void testParse_listAssignmentInvalid_InvalidCommandException() {
        String currentModule = "CS2113T";
        Parser.setCurrentModule(currentModule);
        String inputString = "list assignment     ";
        assertThrows(InvalidCommandException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_setAssignmentDeadlineValid_SetAssignmentDeadlineCommand() throws ModManException {
        String currentModule = "CS2113T";
        Parser.setCurrentModule(currentModule);
        String inputString = "set assignment deadline /a quiz1 /d 16 08 2021";
        Command c = Parser.parse(inputString);
        assertTrue(c instanceof SetAssignmentDeadlineCommand);
    }

    @Test
    void testParse_setAssignmentDeadlineMissingParam_InvalidCommandException() {
        String currentModule = "CS2113T";
        Parser.setCurrentModule(currentModule);
        String inputString = "set assignment deadline /a quiz1 ";
        assertThrows(InsufficientParametersException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_setAssignmentDeadlineInvalidDateFormat_DateTimeFormatException() {
        String currentModule = "CS2113T";
        Parser.setCurrentModule(currentModule);
        String inputString = "set assignment deadline /a quiz1 /d 1613 2021";
        assertThrows(DateTimeFormatException.class, () -> Parser.parse(inputString));
    }

    @Test
    void testParse_invalidInput_expectException() {
        String currentModule = "CS2113T";
        Parser.setCurrentModule(currentModule);
        String inputString = "blah";
        assertThrows(InvalidCommandException.class, () -> Parser.parse(inputString));
    }
}
