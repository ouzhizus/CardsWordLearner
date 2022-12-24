import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddWords{
    public static void addNewWords(){
        Scanner sc = new Scanner(System.in);
        try{
            FileWriter file = new FileWriter("C:\\Users\\ouzhi\\OneDrive\\Документы\\cardsLibrary\\input.txt",true);
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
}