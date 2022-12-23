import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            while ((reader.readLine()) != null){
                arrayLength++;
            }
            reader.close(); //
            System.out.println(arrayLength);
            if(arrayLength == 0){
                System.out.println("File is empty");
                try{
                    FileWriter file = new FileWriter("input.txt",true);
                    BufferedWriter writer = new BufferedWriter(file);
                    while (true) {
                        System.out.print("Import a line to write: ");
                        String userInput = sc.nextLine().toLowerCase();
                        if(userInput.equals("stop")){
                            break;
                        }
                        String[] words = userInput.split(" ");
                        if(words.length >= 3 || words.length == 1){
                            System.out.println("Please,enter two words");
                            continue;
                        }
                        else{
                            writer.write(userInput);
                            writer.newLine();
                            writer.flush();
                        }
                        System.out.println("If you want to stop,use 'STOP' ");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                BufferedReader reader2 = new BufferedReader(new FileReader("input.txt"));
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
                //AddWords.AddWords();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}