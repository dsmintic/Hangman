import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int userInput;
        int badGuessesCount = 0;
        int maxBadGuesses = 6;

        ArrayList<String> words = new ArrayList<String>();
        words.add("cat");
        words.add("dog");
        words.add("java");
        words.add("fish");
        words.add("apple");
        words.add("boots");
        words.add("laptop");
        words.add("class");
        words.add("cake");
        words.add("bread");

        String randomWord = words.get(rand.nextInt(words.size()));

        System.out.println("\nWelcome to the game console");
        System.out.println("Choose an option");
        System.out.println("1 - Start new Hangman game");
        System.out.println("2 - Exit game");
        System.out.println("------------------------------");
        userInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println(randomWord);


        if (userInput == 1) {
            System.out.println("Guess the first letter of the word. Good luck :)");
        }

        //Converts letters of random words to underscore
        char[] secretWord = new char[randomWord.length()];
        for (int i = 0; i < randomWord.length(); i++) {
            secretWord[i] = '_';
            System.out.print("_ ");
        }
        //Converts the letters of a random word in an ArrayList so I can count wrong guesses
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i <randomWord.length(); i++){
            letters.add(randomWord.charAt(i));
        }

        do {
            printHangman(badGuessesCount);

            boolean letterFound = false;
            System.out.print("\nChoose and enter a letter (a-z): ");
            String userLetter = scanner.nextLine();

            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == userLetter.charAt(0)) {
                    secretWord[i] = randomWord.charAt(i);
                    letterFound = true;
                }
            }

            if (letterFound == false){
                System.out.println("You chose the wrong letter. Please try again.");
            }

            int correctLetters = 0;
            for (int i = 0; i < secretWord.length; i++) {
                System.out.print(secretWord[i] + " ");
                if (secretWord[i] != '_') {
                    correctLetters++;
                }
            }

            if (correctLetters == randomWord.length()){
                System.out.println("\nCongratulations! You won the game!");
                break;
            }

            if (!letters.contains(userLetter.charAt(0))){
                badGuessesCount++;
            }

            if (maxBadGuesses == badGuessesCount){
                printHangman(badGuessesCount);
                System.out.println("\nYou used 6 attempts. Unfortunately you lost the game :(");
                break;
            }

        } while (true);
    }

    public static void printHangman(int badGuessesCount){
//-------
//      |
//      O
//     \ /
//      |
//     / \

        System.out.println();
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