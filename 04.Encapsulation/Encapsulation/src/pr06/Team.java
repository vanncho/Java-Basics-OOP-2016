package pr06;

import java.util.HashMap;

public class Team {
    private String name;
    HashMap<String, Player> listOfPlayers;

    public Team(String name) {
        this.setName(name);
        this.listOfPlayers = new HashMap<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player){
        listOfPlayers.put(player.getName(), player);
    }

    public void removePlayer(String playerName){
            listOfPlayers.remove(playerName);
    }
}
