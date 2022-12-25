import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in,"Cp866");
        String os = System.getProperty("os.name").toLowerCase();
        String userName = System.getProperty("user.name");
        String PrePath = "";
        String path = "";
        String mkdirPath = "";
        String userFileName = "";
        String checkPath = "";
        String chosenFile = "";
        if(os.contains("windows")) {
            System.out.print("Do you want to create a new file? YES/NO \n --> ");
            String userAnswer = sc.next().toLowerCase();
            if(userAnswer.contains("yes")){
                System.out.print("Create a file name: ");
                userFileName = sc.next();
            } else if (userAnswer.contains("no")) {
                System.out.println("-------------------------------------");
            }
            checkPath = "C:\\Users\\"+userName+"\\OneDrive\\Документы\\cardsLibrary";
            if(!Files.exists(Path.of(checkPath))){
                System.out.println("Folder doesn't exist");
            }
            PrePath = "C:\\Users\\"+userName+"\\OneDrive\\Документы\\cardsLibrary\\"+userFileName+".txt";
            mkdirPath = "C:\\Users\\"+userName +"\\OneDrive\\Документы\\cardsLibrary";
            File f = new File(PrePath);
            File mkdir = new File(mkdirPath);
            if (mkdir.mkdirs()) {
                System.out.println("Folder 'cardsLibrary' was created");
                if (f.createNewFile()) {
                    System.out.println("File "+userFileName+" was created at " + PrePath);
                }
            }
            else if (f.createNewFile()) {
                System.out.println("File '"+userFileName+"' was created at " + PrePath);
            }
            else{
                File directoryPath = new File(mkdirPath);
                String[] dirContent = directoryPath.list();
                int amountOfFiles = 0;
                for(String file : dirContent){
                    amountOfFiles++;
                    System.out.printf("%s) %s \n",amountOfFiles,file);
                }
                System.out.println("-------------------------------------");
                System.out.print("Choose a file by number: ");
                int userChoice = sc.nextInt();
                chosenFile = dirContent[userChoice-1];
            }
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix") || os.contains("untu")) {
            path = "~\\Documents\\" + userName + "cardsLibrary\\"+chosenFile;
            mkdirPath = path.replace("\\input.txt", "");
            File f = new File(path);
            File mkdir = new File(mkdirPath);
            if (mkdir.mkdirs()) {
                System.out.println("Folder 'cardsLibrary' was created");
                if (f.createNewFile()) {
                    System.out.println("File 'input.txt' was created at " + path);
                }
            }
        }
        path = "C:\\Users\\"+userName+"\\OneDrive\\Документы\\cardsLibrary\\"+chosenFile;
        int arrayLength = 0;
        String line;
        try {
            BufferedReader reader = new BufferedReader
                    (new FileReader(path));
            while ((reader.readLine()) != null) {
                arrayLength++;
            }
            if (arrayLength == 0) {
                System.out.println("File is empty");
                AddWords.addNewWords(path);
                System.out.println("-------------------------------------");
                System.out.println("Please,restart the application \t (click)");
                sc.next();
            }
            reader.close();
            BufferedReader reader2 = new BufferedReader
                    (new FileReader(path));
            String[] originalWords = new String[arrayLength];
            String[] translatedWords = new String[arrayLength];
            int i = 0;
            if(arrayLength != 0){
                while ((line = reader2.readLine()) != null) {
                    String[] words = line.split(" ");
                    originalWords[i] = words[0]; //adds a first word of line
                    translatedWords[i] = words[1]; //adds a second word of line
                    i++;
                }
                Gameplay.wordsPlay(originalWords, translatedWords, path);
            }
        } catch (FileNotFoundException e) {
            System.out.println("-------------------------------------");
            System.out.println("Please,restart the application \t (click)");
            sc.next();
        }
    }
}