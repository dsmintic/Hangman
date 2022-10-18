import java.util.ArrayList;
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


        Scanner scanner = new Scanner(System.in);

        int userInput;

        ArrayList<String> words = new ArrayList<String>();
        words.add("cat");
        words.add("dog");
        words.add("java");
        words.add("fish");
        words.add("apple");
        words.add("boots");
        words.add("laptop");
        words.add("fish");
        words.add("dog");
        words.add("dog");



        System.out.println("Welcome to the HANGMAN game");
        System.out.println("Choose an option");
        System.out.println("1 - Start new game");
        System.out.println("2 - Exit game");
        userInput = scanner.nextInt();
        scanner.nextLine();
    }
}