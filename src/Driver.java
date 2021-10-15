import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("- RAID BOSS GAME -");
        Game game = null;
        while (game == null) {
            try {
                // * 1. Ask for players info
                Player player = askForPlayerInfo();
                // TODO change later
                ArrayList<Player> players = new ArrayList<Player>();
                players.add(player);
                game = new Game(players);   // Create the new game instance
                showInfo("A new game has been created.\nGood Luck!");
            } catch (Exception e) {
                //TODO: handle exception
            }
            
            
        }
       
    }

    public static void showMenu() {

    }

    public static void showAttackMenu() {
    }

    public static void showInfo(String message) {

    }

    public static void showError(String error) {

    }

    public static Player askForPlayerInfo() {
        return null;
    }

    public static void takeTurn(Game game) {

    }

    public static void showGameState(Game game) {

    }

}
