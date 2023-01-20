import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        String userName = System.getProperty("user.name");
        String pathToFolder = "";
        if(os.contains("linux")){
            pathToFolder = "/home/"+userName+"/Documents/cardsLibrary";
        } else if (os.contains("windows")) {
            pathToFolder = "C:\\Users\\"+userName+"\\Documents\\";
        } else{
            System.out.println("Your system is not supported yet");
            Thread.sleep(1000);
        }
        File file = new File(pathToFolder);
        if(file.mkdir()){
            System.out.println("Folder was created at "+pathToFolder);
            System.out.println("Please,go to the folder and create a new txt file");
            System.out.println("Words should be written in format 'Word' - 'Word'");
        }else {
            try{
                File[] amountOfFiles = file.listFiles();
                if(Objects.requireNonNull(amountOfFiles).length == 0){
                    System.out.println("File is empty");
                }
                else{
                    String[] fileLinksName = new String[amountOfFiles.length];
                    for(int i = 0; i < Objects.requireNonNull(amountOfFiles).length;) {
                        String innerFile = amountOfFiles[i].getName();
                        File f = amountOfFiles[i];
                        if (f.isDirectory()) {
                            fileLinksName[i] = f.getName();
                            System.out.println((i+1) + ") "+ f.getName() + " (folder)");
                            i++;
                        }
                        else if (innerFile.contains(".txt")) {
                            fileLinksName[i] = amountOfFiles[i].getName();
                            System.out.println((i + 1) + ") " + amountOfFiles[i].getName());
                            i++;
                        }
                    }
                    System.out.println("-------------------------------------");
                    System.out.print("Choose a file: ");
                    Scanner sc = new Scanner(System.in);
                    int userFileChoice = Integer.parseInt(sc.nextLine());
                    while(userFileChoice > amountOfFiles.length || userFileChoice < 1){
                        System.out.print("Please,input a valid number: ");
                        userFileChoice = Integer.parseInt(sc.nextLine());
                    }
                    String path = pathToFolder + "/" + fileLinksName[userFileChoice-1];
                    File checker = new File(path);
                    if(checker.isDirectory()){
                        ClearConsole();
                        System.out.println("You've chosen a folder");
                        System.out.println("-------------------------------------");
                        File[] amountOfInnerFiles = checker.listFiles();
                        if(Objects.requireNonNull(amountOfInnerFiles).length == 0){
                            System.out.println("Folder is empty");
                        }
                        else{
                            //read files and give it as output

                        }
                    }
                    else{
                        try{
                            parseFile(path);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch (Exception e){
                System.err.println("Error occurred");
            }
        }
    }
    public static void ClearConsole() throws IOException{
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("linux")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        if(os.contains("windows")){
            Runtime.getRuntime().exec("cls");
        }
    }
    public static void parseFile(String path) throws IOException {
        List<String>origWords = new ArrayList<>();
        List<String>transWords = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        while(scanner.hasNextLine()){
            String[] eachLine = scanner.nextLine().split(" - ");
            if(eachLine.length >= 2){
                origWords.add(eachLine[0]);
                transWords.add(eachLine[1]);
            }
        }
        ClearConsole();
        Gameplay.wordsPlay(origWords,transWords);
    }
}