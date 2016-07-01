package pr05;

import pr05.exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song {
    private String artistName;
    private String songName;
    private String songLength;
    private int min;
    private int sec;

    public Song(String artistName, String songName, String songLength) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(songLength);
    }

    private void setArtistName(String artistName) {

        if (artistName == null || artistName.trim().length() < 3 || artistName.trim().length() > 20) {
            throw new InvalidArtistNameException();
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {

        if (songName == null || songName.trim().length() < 3 || songName.trim().length() > 30) {
            throw new InvalidSongNameException();
        }

        this.songName = songName;
    }

    private void setSongLength(String songLength) {

        String[] lengthTokens = songLength.split(":");
        String regex = "^(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(lengthTokens[0]);
        Matcher matcher2 = pattern.matcher(lengthTokens[1]);

        if (!matcher1.find() || !matcher2.find()) {
            throw new InvalidSongLengthException();
        }

        int min = Integer.valueOf(lengthTokens[0]);
        if (min < 0 || min > 14) {
            throw new InvalidSongMinutesException();
        }

        if (lengthTokens.length > 1) {
            int sec = Integer.valueOf(lengthTokens[1]);
            if (sec < 0 || sec > 59) {
                throw new InvalidSongSecondsException();
            }
            this.sec = sec;
        }

        this.songLength = songLength;
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }
}
