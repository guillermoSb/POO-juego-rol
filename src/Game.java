import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Character> enemies;
    private int score;
    private int level;
    private boolean gameOver = false;
    private boolean victory = false;    // TODO: ADD TO THE UML
    private Character currentTurn = null;
    private String gameState = "";

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
        // * 2.2 Create raid boss companions
        Enemy enemy = new Enemy("Alien Soldier");
        Boss boss = new Boss("Alien Boss");
        // The companions will be added to the enemies array and to the companions array
        enemies.add(enemy);
        enemies.add(boss);
        this.enemies = enemies; // Set the enemies array
        this.players = players;
        this.currentTurn = players.get(0);
    }

    String getGameState() {
        return this.gameState;
    }

    boolean getGameOver() {
        return this.gameOver;
    }

    // TODO: ADD TO UML
    void checkForGameOver() {
        if (enemies.get(0).health <= 0) {
            this.victory = true;
            return;
        } 
        boolean playersDefeated = true;
        for (Player player : players) {
            if (player.getHealth() > 0) {
                playersDefeated = false;
            }
        }
        if (playersDefeated) {
            this.gameOver = true;
        }
    }

    void changeToNextTurn() {
        // * 0. Check if Game Over
        this.checkForGameOver();
        // * 1. Check if it is a player turn
        int playerIndex = getPlayers().indexOf(getCurrentTurn());
        if (playerIndex >= 0) {
            // * 1.1 Get next index
            if (getPlayers().size() > playerIndex + 1) {
                setCurrentTurn(getPlayers().get(playerIndex + 1));
            } else {
                // * 1.2 Set the first enemy index
                setCurrentTurn(getEnemies().get(0));
            }
        } else {
            // * 2. Check if it is an Enemy turn
            int enemyIndex = getEnemies().indexOf(getCurrentTurn());
            if (enemyIndex >= 0) {
                // * 2.1 Get next index
                if (getEnemies().size() > enemyIndex + 1) {
                    setCurrentTurn(getEnemies().get(enemyIndex + 1));
                } else {
                    // * 2.2 Set the first enemy index
                    setCurrentTurn(getPlayers().get(0));
                }
            }
        }
    };

    Character getCurrentTurn() {
        return this.currentTurn;
    }

    void setCurrentTurn(Character character) {
        this.currentTurn = character;
    }

    ArrayList<Character> getEnemies() {
        return this.enemies;
    }

    ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public String toString() {
        String game = "";
        game += String.format("Current Level: %d\n", level);
        
        game += String.format("Players: \n");
        for (int i = 0; i < players.size(); i++) {
            game += String.format("%d - %s\n", i + 1, players.get(i).toString());
        }
        
        game += String.format("Enemies: \n");
        for (int i = 0; i < enemies.size(); i++) {
            game += String.format("%d - %s\n", i + 1, enemies.get(i).toString());
        }
        return game;
    }

}