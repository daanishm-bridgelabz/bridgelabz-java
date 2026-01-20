package SnakeAndLadder;

public class SnakeAndLadderGame {

    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;

    private static final int WINNING_POSITION = 100;

    private int diceCount = 0;

    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    private int getOption() {
        return (int) (Math.random() * 3);
    }

    public boolean playTurn(Player player) {

        int dice = rollDice();
        diceCount++;

        int option = getOption();
        int currentPos = player.getPosition();

        switch (option) {
            case NO_PLAY:
                break;

            case LADDER:
                currentPos += dice;
                break;

            case SNAKE:
                currentPos -= dice;
                break;
        }

        if (currentPos < 0) {
            currentPos = 0;
        }

        if (currentPos <= WINNING_POSITION) {
            player.setPosition(currentPos);
        }

        System.out.println(player.getName()
                + " rolled " + dice
                + " | Position: " + player.getPosition());

        return option == LADDER;
    }

    public int getDiceCount() {
        return diceCount;
    }
}
