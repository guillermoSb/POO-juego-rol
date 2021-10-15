import java.util.ArrayList;

public class Warrior extends Player {

    Warrior(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name, items);
        //TODO Auto-generated constructor stub
    }

    Warrior(String name) {
        super(150, 1, 0, name, new ArrayList<Item>());
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
        
    }
    
}
