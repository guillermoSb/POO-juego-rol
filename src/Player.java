import java.util.ArrayList;

public abstract class Player extends Character {

    protected ArrayList<Item> items;    // Items that the user is playing
    protected boolean usingItem = false;    // Indicates if the player is using an item

    /**
     * Creates a Player with all of the params
     */
    Player(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name);
        this.items = items;
    }

    /**
     * Returns wether the player is using an item
     * @return <code>boolean</code>
     */
    public boolean isUsingItem() {
        return usingItem;
    }

    /**
     * Indicates that the player is using or not an item
     * @param usingItem
     */
    public void setUsingItem(boolean usingItem) {
        this.usingItem = usingItem;
    }

    /**
     * Get all the items on the user backpack
     * @return <code>ArrayList<Item></code>
     */
    ArrayList<Item> getItems() {
        return this.items;
    }
    
    /**
     * Set the item list for the Player
     * @param items
     */
    void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Uses an item
     * @param itemIndex
     * @param character
     */
    void useItem(int itemIndex, Character character) {
        // * 1. Evaluate all the item types
        Item item = this.items.get(itemIndex);
        // * 2. Increase the health of the player
        if (item.type == 0) {
            health += 30;
        } else if (item.type == 1) {
            // * 3. Increase the player 
            damageMultiplier = damageMultiplier * 2;
        }
        // * 4. Update the item state
        if (item.type != 0) {
            usingItem = true;
        }
        this.items.remove(itemIndex);
        
    }

    /**
     * Attacks a character
     * @param character
     */
    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }

    @Override
    /**
     * Resets the hability for the player
     */
    public void resetHability() {
        this.damageMultiplier = 1;
    }
}
