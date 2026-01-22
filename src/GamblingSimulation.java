package GamblingSimulation;

import java.util.Random;

public class GamblingSimulation {

    private static final int STAKE = 100;
    private static final int BET_AMOUNT = 1;
    private static final int UPPER_LIMIT = 150;
    private static final int LOWER_LIMIT = 50;
    private static final int DAYS_IN_MONTH = 20;

    private static final Random random = new Random();

    public static void main(String[] args) {
        simulateMonth();
    }

    private static void simulateMonth() {
        int totalAmount = 0;
        int winDays = 0;
        int lossDays = 0;

        int maxWin = Integer.MIN_VALUE;
        int maxLoss = Integer.MAX_VALUE;
        int luckiestDay = 0;
        int unluckiestDay = 0;

        for (int day = 1; day <= DAYS_IN_MONTH; day++) {
            int dailyResult = playOneDay();

            totalAmount += dailyResult;

            if (dailyResult > 0) {
                winDays++;
            } else {
                lossDays++;
            }

            if (dailyResult > maxWin) {
                maxWin = dailyResult;
                luckiestDay = day;
            }

            if (dailyResult < maxLoss) {
                maxLoss = dailyResult;
                unluckiestDay = day;
            }
        }

        System.out.println("Total Amount after 20 days: " + totalAmount);
        System.out.println("Winning Days: " + winDays);
        System.out.println("Losing Days: " + lossDays);
        System.out.println("Luckiest Day: Day " + luckiestDay + " (Won " + maxWin + ")");
        System.out.println("Unluckiest Day: Day " + unluckiestDay + " (Lost " + Math.abs(maxLoss) + ")");

        if (totalAmount > 0) {
            System.out.println("Gambler won overall. Continue next month.");
        } else {
            System.out.println("Gambler lost overall. Stop gambling.");
        }
    }

    private static int playOneDay() {
        int stake = STAKE;

        while (stake > LOWER_LIMIT && stake < UPPER_LIMIT) {
            stake += playOneBet();
        }

        return stake - STAKE;
    }

    private static int playOneBet() {
        return random.nextBoolean() ? BET_AMOUNT : -BET_AMOUNT;
    }
}
