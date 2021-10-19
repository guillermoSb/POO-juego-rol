
/**
 * Creates a Boss enemy, it is stronger than the normal Enemy
 */
public class Boss extends Character {

    /**
     * Creates a Boss Enemy with all the params needed
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     */
    Boss(int health, int hability, int habilityCounter, String name) {
        super(health, hability, habilityCounter, name);
    }

    /**
     * Creates a Boss Enemy with just the name
     * @param name
     */
    Boss(String name) {
        super(200, 0, 0, name);
    }


    /**
     * Attacks an specific character
     */
    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - (damageMultiplier * 10));
        if (isUsingHability()) {
            setUsingHability(false);
            resetHability();
        }
        
    }

    /**
     * Resets the hability
     */
    @Override
    public void resetHability() {
        setDamageMultiplier(1);
    }
    
}
