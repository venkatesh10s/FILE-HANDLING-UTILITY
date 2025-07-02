import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler handler = new FileHandler();

        while (true) {
            System.out.println("\n========= File Handling Utility =========");
            System.out.println("1. Read File");
            System.out.println("2. Write to File");
            System.out.println("3. Modify File (Append)");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    handler.readFile();
                    break;
                case 2:
                    handler.writeFile();
                    break;
                case 3:
                    handler.modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close(); // ✅ Close scanner here
                    return;
                default:
                    System.out.println("[Warning] Invalid option. Please choose between 1 and 4.");
            }
        }
    }
}
