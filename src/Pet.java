public class Pet extends Character {

    Pet(String name){
        super(100, -1, 0, name);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth(); // Get the character health
        health = health - (10 * damageMultiplier);
        character.setHealth(Math.max(0, health));
    }
}
