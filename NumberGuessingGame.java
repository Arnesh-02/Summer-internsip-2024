import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 5;
        int score = 0;
        int round = 1;

        while (round <= maxRounds) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + ": Guess the number between 1 and 100");

            while (attempts < 10 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    hasGuessedCorrectly = true;
                    score += 10 - attempts;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your score for this round: " + (10 - attempts) + "\n");
            round++;

            if (round <= maxRounds) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("Game over. Your total score is: " + score);
    }
}
