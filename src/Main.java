import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String os = System.getProperty("os.name").toLowerCase();
        String userName = System.getProperty("user.name");
        String path;
        String mkdirPath;
        if(os.contains("windows")) {
            path = "C:\\Users\\" + userName + "\\OneDrive\\Документы\\cardsLibrary\\input.txt";
            mkdirPath = path.replace("\\input.txt", "");
            File f = new File(path);
            File mkdir = new File(mkdirPath);
            if (mkdir.mkdirs()) {
                System.out.println("Folder 'cardsLibrary' was created");
                if (f.createNewFile()) {
                    System.out.println("File 'input.txt' was created at " + path);
                }
            }
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            path = "~\\Documents\\" + userName + "cardsLibrary\\input.txt";
            mkdirPath = path.replace("\\input.txt", "");
            File f = new File(path);
            File mkdir = new File(mkdirPath);
            if (mkdir.mkdirs()) {
                System.out.println("Folder 'cardsLibrary' was created");
                if (f.createNewFile()) {
                    System.out.println("File 'input.txt' was created at " + path);
                }
            }
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
                }
                reader.close();
                BufferedReader reader2 = new BufferedReader
                        (new FileReader(path));
                String[] originalWords = new String[arrayLength];
                String[] translatedWords = new String[arrayLength];
                int i = 0;
                while ((line = reader2.readLine()) != null) {
                    String[] words = line.split(" ");
                    originalWords[i] = words[0]; //adds a first word of line
                    translatedWords[i] = words[1]; //adds a second word of line
                    i++;
                }
                Gameplay.wordsPlay(originalWords, translatedWords, path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}