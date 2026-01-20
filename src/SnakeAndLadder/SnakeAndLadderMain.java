package SnakeAndLadder;

public class SnakeAndLadderMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Snake and Ladder Game");

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        SnakeAndLadderGame game = new SnakeAndLadderGame();

        Player currentPlayer = player1;

        while (player1.getPosition() < 100 &&
                player2.getPosition() < 100) {

            boolean extraTurn;
            do {
                extraTurn = game.playTurn(currentPlayer);
            } while (extraTurn && currentPlayer.getPosition() < 100);

            currentPlayer =
                    (currentPlayer == player1) ? player2 : player1;
        }

        Player winner =
                (player1.getPosition() == 100) ? player1 : player2;

        System.out.println("\nWinner is: " + winner.getName());
        System.out.println("Total Dice Rolls: " + game.getDiceCount());
    }
}
