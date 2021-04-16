package seedu.duke.exception;

public class CommentsTooLongException extends ModManException {
    public CommentsTooLongException() {
        this.errorMessage = "Please limit your comments to 100 characters.";
    }
}
