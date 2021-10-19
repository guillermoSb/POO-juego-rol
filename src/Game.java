import java.util.ArrayList;

/**
 * Defines thee current game
 */
public class Game {
    private ArrayList<Player> players;  // Players of the game
    private ArrayList<Character> enemies;   // Enemies of the game
    private int level;  // Current Level
    private int score;
    private boolean gameOver = false;   // Shows if the game is over
    private boolean victory = false;    // Shows if the player has won    // TODO: ADD TO THE UML
    private Character currentTurn = null;   // Current character playing
    private String gameState = "";  // Game state

    /**
     * Creates a Game with all the parametters needed
     * @param players
     * @param enemies
     * @param score
     * @param level
     */
    Game(ArrayList<Player> players, ArrayList<Character> enemies, int score, int level) {
        this.players = players; 
        this.enemies = enemies;
        this.score = score;
        this.level = level;
        this.currentTurn = players.get(0);
    }
    
    /**
     * Creates a Game with all the players as a list and random enemies
     * @param players
     */
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

    /**
     * Gets the game state
     * @return <code>String</code>
     */
    String getGameState() {
        return this.gameState;
    }

    /**
     * Gets the game over state
     * @return <code>boolean</code>
     */
    boolean getGameOver() {
        return this.gameOver;
    }

    // TODO: ADD TO UML
    /**
     * Checks if the game has ended
     */
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

    /**
     * Changes to the next turn
     */
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

    /**
     * Gets the current character playing
     * @return <code>Character</code>
     */
    Character getCurrentTurn() {
        return this.currentTurn;
    }

    /**
     * Set the current character turn
     * @param character
     */
    void setCurrentTurn(Character character) {
        this.currentTurn = character;
    }

    /**
     * Gets the Enemies
     * @return <code>ArrayList<Character></code>
     */
    ArrayList<Character> getEnemies() {
        return this.enemies;
    }

    /**
     * Gets the Players
     * @return <code>ArrayList<Character></code>
     */
    ArrayList<Player> getPlayers() {
        return this.players;
    }


    /**
     * Return the string representation for the game
     */
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