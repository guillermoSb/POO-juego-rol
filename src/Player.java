import java.util.ArrayList;

public abstract class Player extends Character {

    ArrayList<Item> items;

    Player(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name);
        this.items = items;
    }

    ArrayList<Item> getItems() {
        return this.items;
    }
    
    void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    void useItem(int itemIndex, Character character) {

    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
}
