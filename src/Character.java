import java.util.ArrayList;
import java.util.Random;

/**
 * Defines a generic Character. It is any instance that interacts with the game.
 */
public abstract class Character {
    
    protected int health, hability, habilityCounter, damageMultiplier;  // Basic characteer indicators
    protected boolean usingHability = false;    // Indicates if the Character is using an hability 
    protected String name;  // Indicates the name of the Character
    
    /**
     * Creates a Character with all the needed parametters
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     */
    Character(int health, int hability, int habilityCounter, String name) {
        this.health = health;
        this.hability = hability;
        this.habilityCounter = habilityCounter;
        this.name = name;
        this.damageMultiplier = 1;
    }
    
    /**
     * Sets the new damage multiplier for the Character
     * @param damageMultiplier
     */
    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    /**
     * Gets the damage multiplier
     * @return <code>int</code>
     */
    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    /**
     * Returns the player hability state
     * @return
     */
    public boolean isUsingHability() {
        return usingHability;
    }

    /**
     * Sets the state of the hability
     * @param usingHability
     */
    public void setUsingHability(boolean usingHability) {
        this.usingHability = usingHability;
    }

    /**
     * Returns the character's health
     * @return <code>int</code>
     */
    int getHealth() {
        return this.health;
    }

    /**
     * Sets the character's health 
     * @param health
     */
    void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the character hability number
     * @return
     */
    int getHability() {
        return this.hability;
    }

    /**
     * Sets thee character hability
     * @param hability
     */
    void setHability(int hability) {
        this.hability = hability;
    }

    /**
     * Gets the current hability counter
     * @return
     */
    int getHabilityCounter() {
        return this.habilityCounter;
    }

    /**
     * Sets the new hability counter
     * @param habilityCounter
     */
    void setHabilityCounter(int habilityCounter) {
        this.habilityCounter = habilityCounter;
    }
    
    /**
     * Gets the Character's name
     * @return
     */
    String getName() {
        return this.name;
    }
    
    /**
     * Sets the Character's name
     * @param name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Shows a message
     * @param message
     * @return <code>String</code>
     */
    String showMessage(String message) {
        return String.format("%s says: %s\n", name, message);
    }

    /**
     * Attacks a random Character
     * @param characters Array of Characters to pick from
     * @return
     */
    public Character attackRandomCharacter(ArrayList<Character> characters){
        Random rand = new Random();
        Character character = characters.get(rand.nextInt(characters.size()));  // Select a random player to attack
        attack(character);
        return character;
    }


    /**
     * Get the String reprsentation for the Character
     */
    @Override
    public String toString() {
        return String.format("%s - %d life left\n", name, health);
    }

    // ABSTRACT METHODS

    /**
     * Attack a random character
     * @param character
     */
    abstract public void attack(Character character);
    
    /**
     * Reset the player hability
     */
    abstract public void resetHability();


}
