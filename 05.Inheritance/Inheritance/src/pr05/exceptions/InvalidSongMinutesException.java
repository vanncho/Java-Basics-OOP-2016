package pr05.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    private static final String MESSAGE = "Song minutes should be between 0 and 14.";

    public InvalidSongMinutesException() {
        super(MESSAGE);
    }
}
