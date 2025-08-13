import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("🎯 Welcome to the Guess the Number Game! 🎯");
        System.out.println("Rules: Try to guess the number between 1 and 100.");

        int totalScore = 0;
        int totalRounds = 3; // number of rounds you want

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\n--- Round " + round + " ---");
            int numberToGuess = random.nextInt(100) + 1; // generates 1 to 100
            int attemptsLeft = 7; // limit attempts per round
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (1-100): ");
                int playerGuess = scanner.nextInt();
                attemptsLeft--;

                if (playerGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = attemptsLeft + 1; // more points for fewer attempts
                    totalScore += points;
                    System.out.println("✅ Correct! You earn " + points + " points.");
                    break;
                } else if (playerGuess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + numberToGuess);
            }
        }

        System.out.println("\n🏆 Game Over! Your Final Score: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
