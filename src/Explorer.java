import java.util.ArrayList;

/**
 * Special type of Player that has more space for items
 */
public class Explorer extends Player{

    /**
     * Create an Explorer with all the parametters
     * @param health
     * @param hability
     * @param habilityCounter
     * @param name
     * @param items
     */
    Explorer(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name, items);
        for (int i = 0; i < 10; i++) {
            Item item = new Item("Magic Pie", 0);
            if (i % 2 == 0) {
                item = new Item("Strength Potion", 1);
            }
            items.add(item);
        }
    }

    /**
     * Creates an Explorer with default parametters
     * @param name
     */
    Explorer(String name) {
        this(200, 1, 0, name, new ArrayList<Item>());
    }

    /**
     * Attacks an specific Character
     * @param character
     */
    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
        
    }
    
}
