import java.util.ArrayList;

/**
 * Warrior Player - Special type that has more health and strenght
 */
public class Warrior extends Player {
    
    /**
     * Create a Warrior Character with all the parametters needed
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     * @param items
     */
    Warrior(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name, items);
        // Create the items
        for (int i = 0; i < 5; i++) {
            Item item = new Item("Magic Pie", 0);
            if (i % 2 == 0) {
                item = new Item("Strength Potion", 1);
            }
            items.add(item);
        }
    }

    /**
     * Creates a Warrior with a name
     * @param name
     */
    Warrior(String name) {
        this(350, 1, 0, name, new ArrayList<Item>());
    }

    /**
     * Attacks an specific character
     * @param character
     */
    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (15 * damageMultiplier);
        character.setHealth(Math.max(0, health));
        
    }

    /**
     * Resets the Player hability
     */
    @Override
    public void resetHability() {
        super.resetHability();
        this.damageMultiplier = 2;
    }
    
}
