import java.util.ArrayList;

/**
 * Defines a Hunter - Special type of player that has normal health and can have a pet
 */
public class Hunter extends Player { 
    Pet pet;    // Pet for the hunter
    int petCoolDown = 0;    // Cooldown to create a new pet

    Hunter(int health, int hability, int habilityCounter, String name, ArrayList<Item> items, Pet pet) {
        super(health, hability, habilityCounter, name, items);
        this.pet = pet;
    }
    
    /**
     * Create a Hunter just using a name
     */
    Hunter(String name) {
        super(150, 2, 0, name, new ArrayList<Item>());
        this.pet = new Pet("Fido");
    }

    /**
     * Get the cooldown for the Pet
     * @return <code>int</code>
     */
    public int getPetCoolDown() {
        return petCoolDown;
    }

    /**
     * Sets the pet cooldown
     * @param petCoolDown
     */
    public void setPetCoolDown(int petCoolDown) {
        this.petCoolDown = petCoolDown;
    }

    /**
     * Gets the pet
     * @return
     */
    public Pet getPet() {return pet;}

    /**
     * Throws the pet to a random Character
     * @param characters
     * @return
     */
    public Character throwPet(ArrayList<Character> characters) {
        // * 1. The pet will decide which enemy to attack
        pet.setHealth(pet.getHealth() - 10);
        if (pet.getHealth() <= 0) {
            petCoolDown = 3;
            pet = null;
        }
        return pet.attackRandomCharacter(characters);
    }
    


    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
}
