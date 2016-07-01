package pr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PR06 {
    static HashMap<String, Team> teams = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (true){
            String[] tokens = line.split(";");

            if (tokens[0].equals("END")){
                break;
            }

            String command = tokens[0];
            String teamName = null;
            String playerName = null;
            double endurance = 0d, sprint = 0d, dribble = 0d, passing = 0d, shooting = 0d;

            switch (command){
                case "Team":
                    teamName = tokens[1];

                    tryToCreateTeam(teamName);
                    break;
                case "Add":
                    teamName = tokens[1];
                    playerName = tokens[2];
                    endurance = Double.valueOf(tokens[3]);
                    sprint = Double.valueOf(tokens[4]);
                    dribble = Double.valueOf(tokens[5]);
                    passing = Double.valueOf(tokens[6]);
                    shooting = Double.valueOf(tokens[7]);

                    try{
                        tryToAddPlayer(teamName, playerName, endurance, sprint, dribble, passing, shooting);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }

                    break;
                case "Remove":
                    teamName = tokens[1];
                    playerName = tokens[2];

                    try{
                        tryToRemovePlayer(teamName, playerName);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }

                    break;
                case "Rating":
                    teamName = tokens[1];

                    try {
                        System.out.printf("%s - %.0f%n", teamName, calculateTeamAverageRating(teamName));
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }

            line = reader.readLine();
        }
    }

    private static double calculateTeamAverageRating(String teamName) {

        if (teams.containsKey(teamName)){
            double av = 0d;
            HashMap<String, Player> teamAndPlayer = teams.get(teamName).listOfPlayers;

            if (teamAndPlayer.size() == 0){
                return 0d;
            }

            for (Map.Entry<String, Player> stringPlayerEntry : teamAndPlayer.entrySet()) {
                av += stringPlayerEntry.getValue().playerRating();
            }

            return av / teamAndPlayer.size();
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }

    private static void tryToRemovePlayer(String teamName, String playerName) {

        if (teams.get(teamName).listOfPlayers.containsKey(playerName)){
            teams.get(teamName).removePlayer(playerName);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, teamName));
        }
    }

    private static void tryToAddPlayer(String teamName, String playerName, double endurance, double sprint, double dribble, double passing, double shooting) {
        try{
            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            Team t = teams.get(teamName);
            if (t != null){
                teams.get(teamName).addPlayer(player);
            } else {
                throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
            }
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void tryToCreateTeam(String teamName) {
        try {
            Team team = new Team(teamName);
            teams.put(teamName, team);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
