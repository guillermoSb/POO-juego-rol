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
}