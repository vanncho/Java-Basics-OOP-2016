package pr05.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    private static final String MESSAGE = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(MESSAGE);
    }
}
