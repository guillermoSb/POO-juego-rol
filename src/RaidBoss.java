import java.util.ArrayList;

/**
 * The main Boss of the game
 */
public class RaidBoss extends Character {

    private ArrayList<Character> companions;    // Companions for this RaidBoss

    /**
     * Creates a RaidBoss with all the parametters needed
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     * @param companions
     */
    RaidBoss(int health, int hability, int habilityCounter, String name, ArrayList<Character> companions) {
        super(health, hability, habilityCounter, name);
        this.companions = companions;
    }

    /**
     * Creates the Raid Boss with just a name
     * @param name
     */
    RaidBoss(String name) {
        super(300, 5, 0, name);
        this.companions = new ArrayList<Character>();
    }

    /**
     * Get the Raid Boss Companions <code>ArrayList<Character></code>
     * @return
     */
    public ArrayList<Character> getCompanions() {
        return this.companions;
    }

    /**
     * Sets the companions for the RaidBoss
     * @param companions
     */
    public void setCompanions(ArrayList<Character> companions){
        this.companions = companions;
    }

    /**
     * Clones a specific companion
     * @param game
     * @return <code></code> String message showing the cloned
     */
    public String clone(Game game) {
        // * 1. Get the index of the enemy that is going to be cloned (ignore first)
        long enemyIndex = Math.round((Math.random() * (game.getEnemies().size() - 1)) + 1);
        // * 2. Add that enemy to the companions
        Character newClone = game.getEnemies().get((int)enemyIndex);
        companions.add(game.getEnemies().get((int)enemyIndex));
        // * 3. Create the new clone
        if (newClone instanceof Enemy) {
            Enemy enemy = (Enemy) newClone;
            Enemy newEnemy = new Enemy(enemy.getHealth(), enemy.getHability(), 0, enemy.getName() + " (Clone)");
            companions.add(newEnemy);
            game.getEnemies().add(newEnemy);
        } else if (newClone instanceof Boss) {
            Boss boss = (Boss) newClone;
            Boss newBoss = new Boss(boss.getHealth(), boss.getHability(), 0, boss.getName() + " (Clone)");
            companions.add(newBoss);
            game.getEnemies().add(newBoss);
        }
        return showMessage(name + " has cloned: " + newClone);

    }

    /**
     * Attacks a specific Character
     */
    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (20 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }

    /**
     * Resets the hability for the raid boss
     */
    @Override
    public void resetHability() {
    }
    
}
