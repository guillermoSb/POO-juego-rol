import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Character> enemies;
    private int score;
    private int level;
    private boolean gameOver = false;
    private Character currentTurn = null;

    Game(ArrayList<Player> players, ArrayList<Character> enemies, int score, int level) {
        this.players = players;
        this.enemies = enemies;
        this.score = score;
        this.level = level;
        this.currentTurn = players.get(0);
    }

    Game(ArrayList<Player> players) {
        // * 1. Create the enemies
        ArrayList<Character> enemies = new ArrayList<Character>();
        // * 1.1 Always create a Raid Boss
        RaidBoss raidBoss = new RaidBoss("Super Bad Raid Boss");
        enemies.add(raidBoss);
        this.enemies = enemies; // Set the enemies array
        this.currentTurn = players.get(0);
    }

    boolean getGameOver() {return this.gameOver;}

    Character getCurrentTurn() {
        return this.currentTurn;
    }
    
    ArrayList<Character> getEnemies() {
        return this.enemies;
    }

    @Override
    public String toString() {
        String game = "";
        game += String.format("Current Level: %d\n", level);
        game += String.format("Enemies: \n");
        for (int i = 0; i < enemies.size(); i++) {
            game += String.format("%d - %s\n", i + 1, enemies.get(i).toString());
        }
        return game;
    }

}