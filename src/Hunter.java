import java.util.ArrayList;

public class Hunter extends Player {
    Pet pet;

    Hunter(int health, int hability, int habilityCounter, String name, ArrayList<Item> items, Pet pet) {
        super(health, hability, habilityCounter, name, items);
        this.pet = pet;
    }
    
    Hunter(String name) {
        super(100, 2, 0, name, new ArrayList<Item>());
        this.pet = new Pet("Fido");
    }

    public Pet getPet() {return pet;}

    public Character throwPet(ArrayList<Character> characters) {
        // * 1. The pet will decide which enemy to attack
        return pet.attackRandomCharacter(characters);
    }


    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
}
