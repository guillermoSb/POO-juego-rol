import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("- RAID BOSS GAME -");
        Game game = null;
        // * 1. Create the Game
        while (game == null) {
            try {
                // * 1. Ask for players info
                ArrayList<Player> players = askForPlayerInfo(); 
                game = new Game(players);   // Create the new game instance
                showInfo("A new game has been created.\nGood Luck!");
            } catch (Exception e) {
                showError("Be sure to choose only valid options");
            }
        }
        // * 2. Game Loop
        Scanner scan = new Scanner(System.in);
        while (!game.getGameOver()) {
            try {
                // * 2.1. Show game state
                System.out.println(game);
                // * 2.2. Check if it is the players turn
                if (game.getCurrentTurn() instanceof Player) {
                    takeTurn(game);
                }
                // * 2.3. Let the player decide what to do
                System.out.flush();  // Clear the screen each time
                game.changeToNextTurn(); // Change to the next turn
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
        System.out.printf("1 - Warrior (More strength and health)\n2 - Explorer (More Item space)\n3 - Hunter (You can have a magic creature that will fight on your side)\n");
    }

    public static void showInfo(String message) {
        System.out.printf("\n[INFO] %s\n", message);
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
        // * 2.1. Players name
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
        Player player = null;
        if (playerType == 1) {
            player = new Warrior(playerName);
        } else if (playerType == 2) {
            player = new Explorer(playerName);
        } else if (playerType == 3) {
            player = new Hunter(playerName);
        }
        players.add(player);    // Add the player to the ArrayList
        return players; // Return the created players
    }

    public static void takeTurn(Game game) throws Exception {
        Scanner scan = new Scanner(System.in);
        // * 1. Show gamee menu
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
            game.getCurrentTurn().attack(game.getEnemies().get(selectedEnemy - 1));
            showInfo(String.format("%s has attacked %s", game.getCurrentTurn().name, game.getEnemies().get(selectedEnemy - 1).getName()));
            
        }
    }

    public static void showGameState(Game game) {

    }

}
