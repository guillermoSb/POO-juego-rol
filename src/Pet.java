/**
 * Defines a Pet that can be used by the Explorer
 */
public class Pet extends Character {

    /**
     * Creates a Pet
     */
    Pet(String name){
        super(30, -1, 0, name);
    }

    /**
     * Attack a specific character
     */
    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
    
    /**
     * Resets the hability for the pet
     */
    @Override
    public void resetHability() {
        // Pet does not have an hability
    }
}
