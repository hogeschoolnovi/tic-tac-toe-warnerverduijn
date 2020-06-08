package novi.basics;

import static novi.basics.Main.PLAYERINPUT;

public class Game {

    private char [] board;
    private int maxRounds;

    private Player player1;
    private Player player2;

    private int drawCount;

    private Player activePlayer;

    public Game(){

        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        maxRounds = board.length;

        this.player1 = player1;
        this.player2 = player2;

        drawCount = 0;

    }

    public void play(Player player1, Player player2) {


        printBoard(board);

        activePlayer = player1;

        for(int round = 0; round < maxRounds; round++) {

            String activePlayerName = activePlayer.getName();

            System.out.println(activePlayerName + ", please choose a field");

            int chosenField = PLAYERINPUT.nextInt();
            int chosenIndex = chosenField - 1;

            if (chosenIndex < 9 && chosenIndex >= 0) {

                if (board[chosenIndex] != player1.getToken() && board[chosenIndex] != player2.getToken()) {

                    board[chosenIndex] = activePlayer.getToken();

                    printBoard(board);
                    // als het spel gewonnen is
                    // tonen wie er gewonnen heeft (de actieve speler)
                    // de actieve speler krijgt een punt
                    // de scores van de spelers tonen
                    // wanneer we in de laatste beurt zijn en niemand gewonnen heeft
                    // aantal keer gelijk spel ophogen
                    // aantal keer gelijk spel tonen
                    // de beurt doorgeven aan de volgende speler (van speler wisselen)
                    // als de actieve speler, speler 1 is:
                    if (activePlayer == player1) {
                        activePlayer = player2;
                    } else {
                        activePlayer = player1;
                    }
                } else {
                    maxRounds++;
                    System.out.println("This field is not available, choose another");
                }
                //versie 2: als het veld leeg is, wanneer de waarde gelijk is aan chosenField
                /*if(board[chosenIndex] != '1' + chosenIndex) {
                    board[chosenIndex] = activePlayerToken;
                }*/
            } else {
                // het mamimale aantal beurten verhogen
                maxRounds++;
                // foutmelding tonen aan de speler
                System.out.println("The chosen field does not exist, try again");
            }

            // -- terug naar het begin van de volgende beurt
        }
    }
    public static void printBoard(char[] board) {
        for (int fieldIndex = 0; fieldIndex < board.length; fieldIndex++) {
            System.out.print(board[fieldIndex] + " ");
            // als we het tweede veld geprint hebben of het vijfde veld geprint hebben
            // dan gaan we naar de volgende regel
            if(fieldIndex == 2 || fieldIndex == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

