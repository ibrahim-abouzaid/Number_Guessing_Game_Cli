import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int guessingNumber = random.nextInt(100) + 1;
        int attemptedGuess = 0, chances = 0;
        boolean correctNumber=false;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.\n");
        System.out.println();
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.println();
        System.out.print("Enter your choice: ");
        int difficulty = scanner.nextInt();//user try and catch
        scanner.nextLine();

        switch (difficulty) {
            case 1:
                chances = 10;
                System.out.print("Great! You have selected the Easy difficulty level.\n" +
                        "Let's start the game!\n");
                break;
            case 2:
                chances = 5;
                System.out.print("Great! You have selected the Medium difficulty level.\n" +
                        "Let's start the game!\n");
                break;
            case 3:
                chances = 3;
                System.out.print("Great! You have selected the Hard difficulty level.\n" +
                        "Let's start the game!\n");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    while (chances!=0&&!correctNumber){
        System.out.println();
        System.out.print("Enter your guess: ");
        int number=scanner.nextInt();
        if(guessingNumber<number){
            System.out.println("Incorrect! The number is less than "+number);
        }
        else if (guessingNumber>number){
            System.out.println("Incorrect! The number is greater than "+number);
        }else{
            attemptedGuess++;
            System.out.printf("Congratulations! You guessed the correct number in %d attempts.",attemptedGuess);
            correctNumber=true;
        }
        chances--;
        attemptedGuess++;
    }
    if(chances==0){
        System.out.println("Game Over 0 chance left :(");
    }


    }
}