import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ouzhi\\OneDrive\\Документы\\cardsLibrary\\input.txt"));
            while ((reader.readLine()) != null){
                arrayLength++;
            }
            if(arrayLength == 0){
                System.out.println("File is empty");
                AddWords.addNewWords();
            }
            reader.close();
            BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\ouzhi\\OneDrive\\Документы\\cardsLibrary\\input.txt"));
            String[] originalWords = new String[arrayLength];
            String[] translatedWords = new String[arrayLength];
            int i = 0;
            while ((line = reader2.readLine()) != null){
                String[] words = line.split(" ");
                //words has only [0,1] positions for first and second word,it's getting clear after each cycle
                originalWords[i] = words[0]; //adds a first word of line
                translatedWords[i] = words[1]; //adds a second word of line
                i++;
                }
                Gameplay.wordsPlay(originalWords,translatedWords);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}