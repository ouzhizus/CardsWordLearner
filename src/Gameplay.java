import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    public static void wordsPlay(String[] originalWords,String[] translatedWords) throws IOException {
            Scanner sc = new Scanner(System.in);
            Random rnd = new Random();
            System.out.println("-------------------------------------");
            System.out.println("You can write 'STOP' to stop the game");
            while (true){
                int random_word = rnd.nextInt(originalWords.length);
                System.out.println("-------------------------------------");
                System.out.println("Word: " + originalWords[random_word]);
                System.out.print("Your guess: ");
                String userGuess = sc.nextLine();
            if (userGuess.equals("stop")) {
                break;
            }
            else{
                System.out.println("Translation is: "+ translatedWords[random_word]);
            }
        }
    }
}
