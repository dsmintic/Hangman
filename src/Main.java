import java.io.CharArrayReader;
import java.util.*;

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
        System.out.println("------------------------------------------------");
        userInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println(randomWord);


        if (userInput == 1) {
            System.out.println("************************************************");
            System.out.println("Guess the first letter of the word. Good luck :)");
            System.out.println("************************************************");
        }

        ArrayList<Character> usedLetter = new ArrayList<>();

        //Converts letters of random words to underscore
        char[] secretWord = new char[randomWord.length()];
        for (int i = 0; i < randomWord.length(); i++) {
            secretWord[i] = '_';
            System.out.print("_ ");
        }
        //Converts the letters of a random word in an ArrayList I can count wrong guesses
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i <randomWord.length(); i++){
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


            if (usedLetter.contains(userLetter.charAt(0))){
                System.out.println("------------------------------------------------");
                System.out.println("You already used that letter.");
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
                    System.out.println("You chose the wrong letter. Please try again.");
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
                System.out.println("\nCongratulations! You won the game!");
                break;
            }

            if (maxBadGuesses == badGuessesCount) {
                printHangman(badGuessesCount);
                System.out.println("*********************************************************");
                System.out.println("You used 6 attempts. Unfortunately you lost the game :(");
                System.out.println("*********************************************************");
                break;
            }
            Collections.sort(usedLetter);
            System.out.println("\nSo far you have used these letters: " + usedLetter.toString().replace("[","").replace("]",""));
        } while (true);
    }

    public static void printHangman(int badGuessesCount){

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