import java.io.*;
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
                if(amountOfFiles.length == 0){
                    System.out.println("File is empty");
                }
                else{
                    String[] fileLinksName = new String[amountOfFiles.length];
                    for(int i = 0; i < Objects.requireNonNull(amountOfFiles).length; i++){
                        String innerFile = amountOfFiles[i].getName();
                        if(innerFile.contains(".txt")){
                            fileLinksName[i] = amountOfFiles[i].getName();
                            System.out.println((i+1)+") "+ amountOfFiles[i].getName());
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
                    try{
                        int counter = 0;
                        String path = pathToFolder + "/" + fileLinksName[userFileChoice-1];
                        BufferedReader reader = new BufferedReader(new FileReader(path));
                        while(reader.readLine() != null){
                            counter++;
                        }
                        String[] origWords = new String[counter];
                        String[] transWords = new String[counter];
                        counter = 0;
                        Scanner scanner = new Scanner(new File(path));
                        while(scanner.hasNextLine()){
                            String[] eachLine = scanner.nextLine().split(" - ");
                            origWords[counter] = eachLine[0];
                            transWords[counter] = eachLine[1];
                            counter++;
                        }
                        ClearConsole();
                        Gameplay.wordsPlay(origWords,transWords);
                    }catch (Exception e){
                        System.err.println("Error occurred");
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
}