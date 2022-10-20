import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
    private static ArrayList<String> words = new ArrayList<String>();
    private static String randomWord;
    private static int numLetters;

    public static String generateAnimal(){
        Random rand = new Random();
        words.add("cat");
        words.add("dog");
        words.add("fish");
        words.add("elephant");
        words.add("giraffe");
        String randomWord = words.get(rand.nextInt(words.size()));
        return randomWord;
    }

//    public static String generateCountry(int numLetters){
        public static String generateCountry(){
        Random rand = new Random();

        words.add("iran");
        words.add("iraq");
        words.add("mali");
        words.add("china");
        words.add("egypt");
        words.add("gabon");
        words.add("nepal");
        words.add("france");
        words.add("denmark");
        words.add("belgium");
        words.add("canada");
        words.add("finland");
        words.add("pakistan");
        words.add("columbia");
        words.add("portugal");
        words.add("venezuela");
        words.add("uzbekistan");
        words.add("afghanistan");

//        for (){
//        if (numLetters == randomWord.length()) {
            String randomWord = words.get(rand.nextInt(words.size()));
//        }
//        if (){
//        }
//        }

        return randomWord;
    }

    public static String generateFood(){
        Random rand = new Random();
        words.add("carrot");
        words.add("cheese");
        words.add("cake");
        words.add("bread");
        words.add("apple");

        if (numLetters == words.size()) {
            String randomWord = words.get(rand.nextInt(words.size()));
        }
        return randomWord;
    }

    public static String getRandomWord() {
        return randomWord;
    }

    public static void setRandomWord(String randomWord) {
        Words.randomWord = randomWord;
    }

    public static int getNumLetters() {
        return numLetters;
    }

    public static void setNumLetters(int numLetters) {
        Words.numLetters = numLetters;
    }
}
