package pr05;

import pr05.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int songsCount = 0;
        int totalMins = 0;
        int totalSecs = 0;
        for (int i = 0; i < n; i++) {

            String[] songTokens = reader.readLine().split(";");

            try {
                String artist = songTokens[0];
                String songName = songTokens[1];
                String length = songTokens[2];

                Song song = new Song(artist, songName, length);
                System.out.println("Song added.");
                songsCount++;

                totalMins += song.getMin();
                totalSecs += song.getSec();

            }
            catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        int tempMin = totalSecs / 60;
        int restSec = totalSecs % 60;
        int hours = (tempMin + totalMins) / 60;
        int restMin = (tempMin + totalMins) % 60;

        System.out.printf("Songs added: %d%n", songsCount);
        System.out.printf("Playlist length: %dh %dm %ds%n", hours, restMin, restSec);
    }
}
