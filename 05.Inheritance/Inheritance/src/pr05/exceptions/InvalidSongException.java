package pr05.exceptions;

public class InvalidSongException extends RuntimeException {
    private static final String MESSAGE = "Invalid song.";

    public InvalidSongException() {
        super(MESSAGE);
    }

    public InvalidSongException(String message) {
        super(message);
    }
}
