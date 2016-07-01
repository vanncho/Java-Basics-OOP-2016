package pr06;

public class Player {
    private String name;
    private double endurance, sprint, dribble, passing, shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {

        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    private void setEndurance(double endurance) {

        if (endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        } else {
            this.endurance = endurance;
        }
    }

    private void setSprint(double sprint) {

        if (sprint < 0 || sprint > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        } else {
            this.sprint = sprint;
        }
    }

    private void setDribble(double dribble) {

        if (dribble < 0 || dribble > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        } else {
            this.dribble = dribble;
        }
    }

    private void setPassing(double passing) {

        if (passing < 0 || passing > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        } else {
            this.passing = passing;
        }
    }

    private void setShooting(double shooting) {

        if (shooting < 0 || shooting > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        } else {
            this.shooting = shooting;
        }
    }

    public String getName() {
        return name;
    }

    public double playerRating(){
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}
