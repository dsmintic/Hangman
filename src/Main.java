import java.io.CharArrayReader;
import java.util.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput;
        int badGuessesCount = 0;
        int maxBadGuesses = 6;

        System.out.println("\n************************************************");
        System.out.println("          Welcome to the game console");
        System.out.println("************************************************");
        System.out.println("\n               Choose an option");
        System.out.println("------------------------------------------------");
        System.out.println("1 - Start new Hangman game");
        System.out.println("2 - Exit game console");
        System.out.println("------------------------------------------------");
        userInput = scanner.nextInt();
        scanner.nextLine();

        if (userInput == 1) {
            System.out.println("\n************************************************");
            System.out.println("Guess the first letter of the word. Good luck :)");
            System.out.println("************************************************");
            System.out.println("\n               Choose a category");
            System.out.println("------------------------------------------------");

            do {
                System.out.println("\n************************************************");
                System.out.println("Choose the category of words you want to guess");
                System.out.println("************************************************");
                System.out.println("1 - Animals");
                System.out.println("2 - Country");
                System.out.println("3 - Food");
                System.out.println("------------------------------------------------");
                userInput = scanner.nextInt();
                scanner.nextLine();
                if (userInput == 1) {
                    System.out.println("================================================");
                    System.out.println("                      Animals");
                    System.out.println("================================================");
                    Words.setRandomWord(Words.generateAnimal());
                    break;
                }
                else if (userInput == 2) {
                    System.out.println("===================================================");
                    System.out.println("                      Country");
                    System.out.println("===================================================");
//                    System.out.println("Give me the number of letters for the word (4 - 11)");
//                    System.out.println("---------------------------------------------------");
//                    int numLetters = scanner.nextInt();
//                  canner.nextLine();
//                  int randomWordLength;
//                  Random Word Length = User input
//                  Words.setRandomWord(Words.generateCountry(Random Word Length));
//
                    Words.setRandomWord(Words.generateCountry());
//                    Words.setRandomWord(Words.generateCountry(numLetters));
                    break;
                }
                else if (userInput == 3) {
                    System.out.println("================================================");
                    System.out.println("                      Food");
                    System.out.println("================================================");
                    Words.setRandomWord(Words.generateFood());
                    break;
                }
            } while (true);

        } else if (userInput >= 2){
            System.out.println("\n************************************************");
            System.out.println("Thanks for playing :)");
            System.out.println("Terminating game console ...");
            System.out.println("************************************************");
            exit(0);
        }

        String randomWord = Words.getRandomWord();
        System.out.println(Words.getRandomWord());

        ArrayList<Character> usedLetter = new ArrayList<>();

        //Converts letters of random words to underscore
        char[] secretWord = new char[randomWord.length()];
        for (int i = 0; i < randomWord.length(); i++) {
            secretWord[i] = '_';
            System.out.print("_ ");
        }
        //Converts the letters of a random word in an ArrayList I can count wrong guesses
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < randomWord.length(); i++) {
            letters.add(randomWord.charAt(i));
        }

        do {
            printHangman(badGuessesCount);

            boolean letterFound = false;
            System.out.println("------------------------------------------------");
            System.out.print("Choose and enter a letter (a-z): ");
            String userLetter = scanner.nextLine();


            while (userLetter.isEmpty() || !Character.isLetter(userLetter.charAt(0))) {
                System.out.println("Please enter only letters from a to z: ");
                userLetter = scanner.nextLine();
            }
            userLetter = userLetter.toLowerCase();


            if (usedLetter.contains(userLetter.charAt(0))) {
                System.out.println("------------------------------------------------");
                System.out.println("\"You already used that letter.\"");
            } else {
                usedLetter.add(userLetter.charAt(0));

                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == userLetter.charAt(0)) {
                        secretWord[i] = randomWord.charAt(i);
                        letterFound = true;
                    }
                }

                if (letterFound == false) {
                    System.out.println("------------------------------------------------");
                    System.out.println("\"You chose the wrong letter. Please try again.\"");
                    System.out.println("------------------------------------------------");
                }
                if (!letters.contains(userLetter.charAt(0))) {
                    badGuessesCount++;
                }
            }

            int correctLetters = 0;
            for (int i = 0; i < secretWord.length; i++) {
                System.out.print(secretWord[i] + " ");
                if (secretWord[i] != '_') {
                    correctLetters++;
                }
            }
            System.out.println();

            if (correctLetters == randomWord.length()) {
                System.out.println("*********************************************************");
                System.out.println("         Congratulations! You won the game!");
                System.out.println("*********************************************************");
                break;
            }

            if (maxBadGuesses == badGuessesCount) {
                printHangman(badGuessesCount);
                System.out.println("*********************************************************");
                System.out.println("\"You used 6 attempts. Unfortunately you lost the game :(\"");
                System.out.println("*********************************************************");
                break;
            }
            Collections.sort(usedLetter);
            System.out.println("\nSo far you have used these letters: " + usedLetter.toString().replace("[", "").replace("]", ""));
        } while (true);

    }


        private static void printHangman (int badGuessesCount){

            System.out.println();
            System.out.println("-------");
            System.out.println("      |");
            if (badGuessesCount >= 1) {
                System.out.println("      0");
            }
            if (badGuessesCount >= 2) {
                System.out.print("     \\");
                if (badGuessesCount >= 3) {
                    System.out.println(" /");
                } else {
                    System.out.println();
                }
            }
            if (badGuessesCount >= 4) {
                System.out.println("      |");
            }
            if (badGuessesCount >= 5) {
                System.out.print("     /");
                if (badGuessesCount >= 6) {
                    System.out.println(" \\");
                } else {
                    System.out.println();
                }
            }
            System.out.println();
        }
}