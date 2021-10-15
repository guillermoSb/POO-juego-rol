import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character {

    Enemy(int health, int hability, int habilityCounter, String name) {
        super(health, hability, habilityCounter, name);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public void attack(Character character) {
        
    }

    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }


    
}
