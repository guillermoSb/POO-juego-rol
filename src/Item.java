/**
 * Defines an item that can be used by the player
 */
public class Item {
    String name;    // Name of the item
    int type;   // Type of the item

    /**
     * Creates an Item
     * @param name
     * @param type
     */
    Item(String name, int type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Get the name of the item
     * @return <code>String</code>
     */
    String getName() {
        return this.name;
    }
    
    /**
     * Gets the type for the item
     * @return <code>int</code>
     */
    int getType() {
        return this.type;
    }
    
    /**
     * Returns the String representation of an item
     */
    @Override
    public String toString() {
        return this.name;
    }
}
