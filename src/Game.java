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
}