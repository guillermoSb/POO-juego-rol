
/**
 * Defines a generic Character. It is any instance that interacts with the game.
 */
public abstract class Character {
    
    int health, hability, habilityCounter, damageMultiplier;
    String name;
    
    Character(int health, int hability, int habilityCounter, String name) {
        this.health = health;
        this.hability = hability;
        this.habilityCounter = habilityCounter;
        this.name = name;
        this.damageMultiplier = 1;
    }

    int getHealth() {
        return this.health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    int getHability() {
        return this.hability;
    }

    void setHability(int hability) {
        this.hability = hability;
    }

    int getHabilityCounter() {
        return this.habilityCounter;
    }

    void setHabilityCounter(int habilityCounter) {
        this.habilityCounter = habilityCounter;
    }
    
    String getName() {
        return this.name;
    }
    
    void setName(String name) {
        this.name = name;
    }

    String showMessage(String message) {
        return String.format("%s says: %s\n", name, message);
    }


    @Override
    public String toString() {
        return String.format("%s - %d life left\n", name, health);
    }

    abstract public void attack(Character character);
    


}
