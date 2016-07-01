package pr05.exceptions;

public class InvalidSongNameException extends InvalidArtistNameException {
    private static final String MESSAGE = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(MESSAGE);
    }
}
