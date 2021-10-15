import java.util.ArrayList;

public class RaidBoss extends Character {

    ArrayList<Character> companions;

    RaidBoss(int health, int hability, int habilityCounter, String name, ArrayList<Character> companions) {
        super(health, hability, habilityCounter, name);
        //TODO Auto-generated constructor stub
        this.companions = companions;
    }
    RaidBoss(String name) {
        super(100, 5, 0, name);
        //TODO Auto-generated constructor stub
        this.companions = new ArrayList<Character>();
    }

    public void clone(Character character) {
        // TODO Implement Later
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
    
}
