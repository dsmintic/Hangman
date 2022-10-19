import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//       TO DO:
//       1. WORDS LIST - String ArrayList (so i can and more words latter)
//       2. Varijabla - Bad guesses - int
//       3. Random choose a word from ArrayList
//       4. Do char Array for correst and incorrect letters
//       5. Do main loop ( hmmm while or do/while - need to think)
//          5.1 Hangman picture (6.2. do it in the end)
//          5.2
//        6. Methods (out of main (static)
//           6.1 for wining a game
//           6.2 display Hangman pic - add 1 body part if incorrect letter (If the letter does not exist on the word, a part of the hangman should be drawn)
//           6.3 Print the correct guesses in the secret word.

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

        System.out.println("Welcome to the game console");
        System.out.println("Choose an option");
        System.out.println("1 - Start new Hangman game");
        System.out.println("2 - Exit game");
        userInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println(randomWord);

        if (userInput == 1) {
            System.out.println("Guess the first letter of the word. Good luck :)");
        }

        char[] secretWord = new char[randomWord.length()];
        for (int i = 0; i < randomWord.length(); i++) {
            secretWord[i] = '_';
            System.out.print("_ ");
        }


        do {
            boolean letterFound = false;
            System.out.println("\nChoose and enter a letter (a-z)");
            String userLetter = scanner.nextLine();
            while (!userLetter.matches("[a-zA-z]")){
                System.out.println("Please enter only letters from a to z.");
                userLetter = scanner.nextLine();
            }
            userLetter = userLetter.toLowerCase();

            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == userLetter.charAt(0)) {
                    secretWord[i] = randomWord.charAt(i);
                    letterFound = true;
                }
            }

            if (letterFound == false){
                System.out.println("You chose the wrong letter.");
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
                System.out.println("\nYou used 6 attempts. Unfortunately you lost the game :(");
                break;
            }

        } while (true);
    }
}