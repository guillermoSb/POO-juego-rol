import java.util.ArrayList;

public class Hunter extends Player {
    Pet pet;

    Hunter(int health, int hability, int habilityCounter, String name, ArrayList<Item> items, Pet pet) {
        super(health, hability, habilityCounter, name, items);
        this.pet = pet;
    }

    public void throwPet(Character character) {
        // TODO Implement later
    }


    @Override
    public void attack(Character character) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
