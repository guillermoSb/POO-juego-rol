import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    ArrayList<Character> enemies;
    int score;
    int level;
    Character currentTurn = null;

    Game(ArrayList<Player> players, ArrayList<Character> enemies, int score, int level) {
        this.players = players;
        this.enemies = enemies;
        this.score = score;
        this.level = level;
    }

    Game(ArrayList<Player> players) {
        // * 1. Create the enemies
        ArrayList<Character> enemies = new ArrayList<Character>();
        // * 1.1 Always create a Raid Boss
        RaidBoss raidBoss = new RaidBoss("Super Bad Raid Boss");
        enemies.add(raidBoss);
        this.enemies = enemies; // Set the enemies array
    }

}