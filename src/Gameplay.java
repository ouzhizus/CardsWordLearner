import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    public static void wordsPlay(String[] originalWords,String[] translatedWords){
            Scanner sc = new Scanner(System.in);
            Random rnd = new Random();
            System.out.println("-------------------------------------");
            System.out.println("You can write 'STOP' or 'EXIT 'to stop the game");
            while (true){
                int random_word = rnd.nextInt(originalWords.length);
                System.out.println("-------------------------------------");
                System.out.println("Word: " + originalWords[random_word]);
                System.out.print("Your guess: ");
                String userGuess = sc.nextLine().toLowerCase();
            if (userGuess.equals("stop") || userGuess.equals("exit")) {
                break;
            }
            else{
                System.out.println("Translation is: "+ translatedWords[random_word]);
            }
        }
    }
}
