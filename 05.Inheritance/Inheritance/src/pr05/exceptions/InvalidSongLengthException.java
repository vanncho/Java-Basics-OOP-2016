package pr05.exceptions;

public class InvalidSongLengthException extends InvalidSongException {
    private static final String MESSAGE = "Invalid song length.";

    public InvalidSongLengthException() {
        super(MESSAGE);
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
