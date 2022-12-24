import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;
        String userName = System.getProperty("user.name");
        String path = "C:\\Users\\"+userName+"\\OneDrive\\Документы\\cardsLibrary\\input.txt";
        System.out.println(userName);
        String line;
        try {
            BufferedReader reader = new BufferedReader
                    (new FileReader(path));
            while ((reader.readLine()) != null){
                arrayLength++;
            }
            if(arrayLength == 0){
                System.out.println("File is empty");
                AddWords.addNewWords(path);
            }
            reader.close();
            BufferedReader reader2 = new BufferedReader
                    (new FileReader(path));
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
                Gameplay.wordsPlay(originalWords,translatedWords,path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}