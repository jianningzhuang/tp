package seedu.duke.exception;

public class IllegalCharacterException extends ModManException {
    public IllegalCharacterException() {
        this.errorMessage = "The character | is illegal in this program! Please use another character.";
    }
}
