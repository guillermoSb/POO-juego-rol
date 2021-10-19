import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\n\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- RAID BOSS GAME -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n\n\n");
        System.out.println("Story: You are traveling through space when an alien spaceship is attacking yours. The battle is reducing your crew and the only way to save everyone is to fight against the Raid Boss...s");
        showInfo("It is recomended to have your console in Full Screen Mode\n");
        Game game = null;
        // * 1. Create the Game
        while (game == null) {
            try {
                // * 1. Ask for player's info
                ArrayList<Player> players = askForPlayerInfo();
                game = new Game(players); // Create the new game instance
                showInfo("A new game has been created.\nGood Luck!");
            } catch (Exception e) {
                showError("Be sure to choose only valid options");
            }
        }
        // * 2. Game Loop
        Scanner scan = new Scanner(System.in);
        while (!game.getGameOver() && !game.isVictory()) {
            try {
                // * 2.1. Show game state
                System.out.println(game);
                showInfo(String.format("Current turn is: %s", game.getCurrentTurn()));
                // * 2.2. Check if it is the players turn
                if (game.getCurrentTurn() instanceof Player) {
                    takeTurn(game);
                } else if (game.getCurrentTurn() instanceof Enemy || game.getCurrentTurn() instanceof RaidBoss
                        || game.getCurrentTurn() instanceof Boss) {
                    takeEnemyTurn(game);
                }
                game.changeToNextTurn();
                if (game.getGameOver()) {
                    showInfo("GAME OVER!!! The RaidBoss won.");
                } else if (game.isVictory()) {
                    showInfo("YOU WON!");

                }
            } catch (Exception e) {
                e.printStackTrace();
                showError("Please choose a valid option.");
            }
        }
        scan.close();

    }

    public static void showMenu() {
        System.out.printf("1 - Attack an enemy\n2 - Use an item / hability\n3 - Next turn\n");
    }

    public static void showAttackMenu() {
    }

    public static void showPlayerTypes() {
        System.out.printf(
                "1 - Warrior (More strength and health)\n2 - Explorer (More Item space)\n3 - Hunter (You can have a magic creature that will fight on your side)\n");
    }

    public static void showInfo(String message) {
        System.out.printf("[INFO] %s\n", message);
    }

    public static void showError(String error) {
        System.out.printf("\n[ERROR] %s\n", error);
    }

    public static ArrayList<Player> askForPlayerInfo() throws Exception {
        ArrayList<Player> players = new ArrayList<Player>();
        // * 1. Define fields to create the player
        String playerName;
        int playerType;
        // * 2. Ask the user to create the player info
        Scanner scan = new Scanner(System.in);
        System.out.print("Player Count (1, 2 or 3): ");
        int playerCount = scan.nextInt();
        scan.nextLine();
        if (playerCount < 1 || playerCount > 3) {
            throw new Exception("Player Count must be between this values: 1, 2 or 3"); // Throw the player exception
        }
        // * 2.1. Players name
        for (int i = 0; i < playerCount; i++) {
            showInfo("Now Creating Player #" + (i + 1));
            System.out.print("Player Name: ");
            playerName = scan.nextLine();
            // * 2.2. Player type
            showPlayerTypes();
            System.out.print("Player Type: ");
            playerType = scan.nextInt();
            // Throw an exception if the player type is not valid
            if (playerType < 1 || playerType > 3) {
                throw new Exception("Player Type is not valid.");
            }
            scan.nextLine();
            Player player = null;
            if (playerType == 1) {
                player = new Warrior(playerName);
            } else if (playerType == 2) {
                player = new Explorer(playerName);
            } else if (playerType == 3) {
                player = new Hunter(playerName);
            }
            players.add(player); // Add the player to the ArrayList
            showInfo("Created Player: " + player);;
        }
        return players; // Return the created players
    }

    public static void clearScreen() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    public static void takeTurn(Game game) throws Exception {
        Player player = (Player) game.getCurrentTurn();
        Scanner scan = new Scanner(System.in);
        // * 1. Show game menu
        showMenu();
        System.out.print("Choose your next move: ");
        int menuOption = scan.nextInt();
        if (menuOption < 1 || menuOption > 3) {
            throw new Exception("Option not valid.");
        }
        // * 2. Evaluate the player options
        if (menuOption == 1) {
            // * 2.1. Attack an enemy
            System.out.print("Enemy to attack: ");
            int selectedEnemy = scan.nextInt();
            if (selectedEnemy < 1 || selectedEnemy > game.getEnemies().size()) {
                throw new Exception("Enemy selection is not valid.");
            }
            // * 2.2 Attack the enemy
            player.attack(game.getEnemies().get(selectedEnemy - 1));
            showGameState(player, game.getEnemies().get(selectedEnemy - 1));
            // * Reset the player habilities if it is using an item
            if (player.isUsingItem()) {
                player.setUsingItem(false);
                player.resetHability();
            }
            
        } else if (menuOption == 2) {
            // * 2.3 If it is a hunter, throw the pet
            if (game.getCurrentTurn() instanceof Hunter) {
                Hunter hunter = (Hunter) game.getCurrentTurn();
                if (hunter.getPetCoolDown() > 0) {
                    showInfo(hunter.getName() + " has to wait " + hunter.getPetCoolDown() + " to throw the pet again");
                    return;
                }
                Character characterAttacked = hunter.throwPet(game.getEnemies());
                if (hunter.getPet() == null) {
                    showInfo(hunter.getName() + "'s pet has died - you can use it again in 3 turns");
                }
                showGameState(hunter.getPet(), characterAttacked);
            } else {
                // Validate that the player is not using an item
                if (player.usingItem) {
                    showInfo(player.getName() + " is already using an item.");
                }
                // * 2.4 Use an item instead
                System.out.println("Current Items:");
                for (int i = 0; i < player.getItems().size(); i++) {
                    System.out.printf("%d - %s\n", i + 1, player.getItems().get(i)); // Print the item
                }
                // * 2.4.1 Ask the user to select an item
                System.out.print("Select an item: ");
                int itemChoosed = scan.nextInt() - 1;
                if (itemChoosed < 0 || itemChoosed >= player.getItems().size()) {
                    throw new Exception("Item selection is not valid");
                }
                // * 2.4.2 Show messages
                if (player.getItems().get(itemChoosed).type == 0) {
                    showInfo(player.getName() + " has eaten a magic Pie and has +30 health.");
                } else if (player.getItems().get(itemChoosed).type == 1) {
                    showInfo(player.getName() + " damage increased is 2X for the next turn.");
                }
                // * 2.4.3 Use the item
                player.useItem(itemChoosed, null);

            }

        }
        // * 3. Change the cooldown for Pet
        if (player instanceof Hunter) {
            Hunter hunter = (Hunter) player;
            hunter.setPetCoolDown(hunter.getPetCoolDown() - 1);
        }
    }

    public static void takeEnemyTurn(Game game) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (Player player : game.getPlayers()) {
            characters.add(player);
        }
        double chance = Math.random();
        if (game.getCurrentTurn() instanceof RaidBoss && (chance) > 0.90) {
            RaidBoss boss = (RaidBoss) game.getCurrentTurn();
            System.out.println("Cloning");
            if (boss.getCompanions().size() <= 0) {
                String clonedMessage = boss.clone(game);
                showInfo(clonedMessage);
                return;
            } else {
                Character characterAttacked = game.getCurrentTurn().attackRandomCharacter(characters);
                showGameState(game.getCurrentTurn(), characterAttacked);
            }
        } else if (game.getCurrentTurn() instanceof RaidBoss && (chance <= 0.90) && chance > 0.80) {
            System.out.println("SET HABILITY");
            RaidBoss boss = (RaidBoss) game.getCurrentTurn();
            if (boss.getCompanions().size() > 0) {
                // Define the new hability
                int hability = (int) Math.round((Math.random() * 1));
                String habilityString = hability == 1 ? "Damage Increase 2X" : "Health increase +20";
                for (Character companion : boss.getCompanions()) {
                    companion.setHability(hability);
                }

                showInfo(boss.getName() + " has changed the hability for its companions " + habilityString);
            } else {
                Character characterAttacked = game.getCurrentTurn().attackRandomCharacter(characters);
                showGameState(game.getCurrentTurn(), characterAttacked);
            }
        } else if (game.getCurrentTurn() instanceof RaidBoss && (chance <= 0.80) && chance > 0.60) {
            RaidBoss boss = (RaidBoss) game.getCurrentTurn();
            System.out.println("Reset compas");

            if (boss.getCompanions().size() > 0) {
                boss.setCompanions(new ArrayList<Character>());
                showInfo(boss.getName() + " has released the companions");
            } else {
                Character characterAttacked = game.getCurrentTurn().attackRandomCharacter(characters);                                                                                // random player
                showGameState(game.getCurrentTurn(), characterAttacked);
            }
        } else if (game.getCurrentTurn() instanceof RaidBoss && (chance <= 0.60) && chance > -1) {
            System.out.println("attack random");
            Character characterAttacked = game.getCurrentTurn().attackRandomCharacter(characters); 
            showGameState(game.getCurrentTurn(), characterAttacked);
        } else if (game.getCurrentTurn() instanceof Boss || game.getCurrentTurn() instanceof Enemy && chance >= 0.80 && !game.getCurrentTurn().isUsingHability()) {
            System.out.println("Normal Turn");
            if (game.getCurrentTurn().hability == 0) {
                System.out.println("Health");
                showInfo(game.getCurrentTurn().getName() + " has used a health hability (+20 health)");
                game.getCurrentTurn().setHealth(game.getCurrentTurn().getHealth() + 20);
            } else if (game.getCurrentTurn().hability == 1) {
                System.out.println("damage");
                game.getCurrentTurn().setDamageMultiplier(2);
                showInfo(game.getCurrentTurn().getName() + " has increased its damage for the next turn (X2)");
                game.getCurrentTurn().setUsingHability(true);
            }
        } else {
            Character characterAttacked = game.getCurrentTurn().attackRandomCharacter(characters);                                                                                // random player
            showGameState(game.getCurrentTurn(), characterAttacked);
        }

    }

    public static void showGameState(Character attacker, Character attacked) {
        showInfo(String.format("%s has attacked %s", attacker.getName(), attacked.getName()));

    }

}
