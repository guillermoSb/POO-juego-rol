import java.util.ArrayList;

public class Explorer extends Player{

    Explorer(int health, int hability, int habilityCounter, String name, ArrayList<Item> items) {
        super(health, hability, habilityCounter, name, items);
        //TODO Auto-generated constructor stub
    }

    Explorer(String name) {
        super(100, 3, 0, name, new ArrayList<Item>());
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
        
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
