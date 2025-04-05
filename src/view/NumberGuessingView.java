package view;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingView  implements NumberGuessingService{
    @Override
    public void runGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int attemptedGuess = 0, chances = 0;
        boolean correctNumber=false;
        int difficulty=0;

        startingMenu();//display welcome menu

        boolean exitGame=false;
        while(!exitGame){
            System.out.println("Please select the difficulty level:");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");
            System.out.println();

        boolean exit=false;

            try {
                difficulty = scanner.nextInt();//user try and catch
            } catch (Exception e) {
                System.out.println("Error: input has to be integer");
                scanner.nextLine();
                continue;
            }

            chances=selectChances(difficulty);
            while(!exit) {
                long startTime = System.currentTimeMillis();
                int guessingNumber = random.nextInt(100) + 1;
                int newChance=chances;
                correctNumber=false;
                attemptedGuess=0;
                int lastGuessNumber=0;
            System.out.println("Let's start the game!");

            while (newChance != 0 && !correctNumber) {
                System.out.println();
                System.out.println("for hint enter -1");
                System.out.print("Enter your guess: ");
                int number = scanner.nextInt();
                if(number==-1){
                    hintSystem(lastGuessNumber,guessingNumber);
                }
                else if (guessingNumber < number) {
                    System.out.println("Incorrect! The number is less than " + number);
                } else if (guessingNumber > number) {
                    System.out.println("Incorrect! The number is greater than " + number);
                } else {
                    attemptedGuess++;
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.\n", attemptedGuess);
                    correctNumber = true;
                }
                newChance--;
                attemptedGuess++;
                if(number!=-1){
                    lastGuessNumber=number;
                }

            }
                long stopTime = System.currentTimeMillis();
                scanner.nextLine();

                System.out.println("you took "+(stopTime-startTime)/1000+"s"); //timer
                // TODO need to check (it display game over if i get the number in my last chance ) //test it

                if (newChance == 0&&!correctNumber) {
                    System.out.println("Game Over 0 chance left :(");
                    System.out.println("the number was "+guessingNumber);
            }
                System.out.println("Play again?");
                System.out.println("1-ok 2-No 3-chose difficulty");
            String newGame=scanner.nextLine();
            if(newGame.equals("2")){
                exit=true;
                exitGame=true;
            }
            else if(newGame.equals("3")){
                exit=true;

            }
        }

        }
        System.out.println("thank you for playing :) have nice day");

    }
    void startingMenu(){
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.\n");
        System.out.println();

    }

    int selectChances(int difficulty){
        int difficultyChance = 0;
        switch (difficulty) {
            case 1:
                difficultyChance = 10;
                System.out.print("Great! You have selected the Easy difficulty level.\n");
                break;
            case 2:
                difficultyChance = 5;
                System.out.print("Great! You have selected the Medium difficulty level.\n");
                break;
            case 3:
                difficultyChance = 3;
                System.out.print("Great! You have selected the Hard difficulty level.\n");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return difficultyChance;


    }
    void hintSystem(int lastguess,int correctNumber){
        Random random = new Random();
        int lastvalue;
        int hintNumber;
        if(lastguess>correctNumber){
            hintNumber=random.nextInt(1,lastguess);
        } else {
            hintNumber=random.nextInt(lastguess,100);
        }
        //may the lastguss be 8 and the correctNumber is 7 so 8+7 =15 / 2 =7.5 and because its int will return 7
        if(correctNumber>hintNumber){
            System.out.println("The number is greater than "+hintNumber);
        }
        else{
            System.out.println("The number is less than "+hintNumber);
        }
    }
}
