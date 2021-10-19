import java.util.ArrayList;
import java.util.Random;

/**
 * Defines a simple Enemy
 */
public class Enemy extends Character {

    /**
     * Crates an Enemy with all the params needed
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     */
    Enemy(int health, int hability, int habilityCounter, String name) {
        super(health, hability, habilityCounter, name);
    }

    /**
     * Creates a standard Enemy
     * @param name
     */
    Enemy(String name) {
        this(100, 0, 0, name);
    }
    

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - (damageMultiplier * 5));
        if (isUsingHability()) {
            resetHability();
        }
    }

    @Override
    public void resetHability() {
        setDamageMultiplier(1);
    }


    
}
