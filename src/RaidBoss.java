import java.util.ArrayList;

public class RaidBoss extends Character {

    ArrayList<Character> companions;

    RaidBoss(int health, int hability, int habilityCounter, String name, ArrayList<Character> companions) {
        super(health, hability, habilityCounter, name);
        //TODO Auto-generated constructor stub
        this.companions = companions;
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
        // TODO Auto-generated method stub
    }
    
}
