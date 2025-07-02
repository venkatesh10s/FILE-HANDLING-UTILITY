import java.io.*;
import java.util.Scanner;

public class FileHandler {
    private final String filePath = "files/sample.txt";
    private final String outputPath = "output/modified_sample.txt";
    private final Scanner scanner = new Scanner(System.in);

    // Read file contents
    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\n--- File Contents ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------");
        } catch (IOException e) {
            System.out.println("[Error] Unable to read file: " + e.getMessage());
        }
    }

    // Write new content to file (overwrites)
    public void writeFile() {
        System.out.print("Enter text to write into the file: ");
        String content = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("[Success] File written successfully.");
        } catch (IOException e) {
            System.out.println("[Error] Unable to write to file: " + e.getMessage());
        }
    }

    // Append content to an output file
    public void modifyFile() {
        System.out.print("Enter text to append to the file: ");
        String content = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("[Success] File modified (appended) successfully.");
        } catch (IOException e) {
            System.out.println("[Error] Unable to modify file: " + e.getMessage());
        }
    }
}
