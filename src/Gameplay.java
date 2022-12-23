import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import java.util.Arrays;
public class Gameplay {
    public static void wordsPlay(String[] originalWords,String[] translatedWords)
    {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random(originalWords.length);
        String[] userDoesntKnow;
        System.out.println("You can write 'STOP' to stop the game");
        System.out.println("You can write 'add word' to add a new word to dictionary");
        while (true){
            int random_word = rnd.nextInt(originalWords.length);
            System.out.println("-------------------------------------");
            System.out.println("Word: " + originalWords[random_word]);
            System.out.print("Translation: ");
            String userGuess = sc.nextLine().toLowerCase();
            if(userGuess.equals(translatedWords[random_word])){
                System.out.println("Great,you're right!");
            }
            else if (userGuess.equals("stop")) {
                break;
            }
            else if (userGuess.equals("add word")) {
                AddWords.AddWords();
            }
            else{
                System.out.println("Translation is: "+ translatedWords[random_word]);
            }
        }
    }
}
