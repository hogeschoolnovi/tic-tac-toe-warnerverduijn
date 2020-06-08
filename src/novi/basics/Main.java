package novi.basics;
import java.util.Scanner;
public class Main {
    public static Scanner PLAYERINPUT = new Scanner(System.in);
    public static void main(String[] args) {


        boolean dontReplayWithOtherPlayers = false;
        while (!dontReplayWithOtherPlayers) {

            System.out.println("Player 1, what is your name?");

            String player1Name = PLAYERINPUT.next();
            Player player1 = new Player(player1Name, 'X');

            System.out.println("Player 2, what is your name?");

            String player2Name = PLAYERINPUT.next();
            Player player2 = new Player(player2Name, 'O');

            boolean dontReplay = false;
            while (!dontReplay) {


                Game game = new Game();
                game.play(player1, player2);


                System.out.println("Choose(type 1, 2 or 3): 1.Replay 2.Replay with other players 3.Quite game");
                int playerChoice = PLAYERINPUT.nextInt();

                if (playerChoice == 1) {
                    dontReplay = false;
                } else {
                    dontReplay = true;
                    ;
                }
                if (playerChoice ==2) {
                    dontReplayWithOtherPlayers = false;
                } else {
                    dontReplayWithOtherPlayers = true;
                }
            }
        }
    }
}