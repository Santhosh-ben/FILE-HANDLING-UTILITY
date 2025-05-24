import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = "data.txt";

        while (true) {
            System.out.println("\nFile Operations:");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeFile(fileName, scanner);
                    break;
                case 2:
                    readFile(fileName);
                    break;
                case 3:
                    modifyFile(fileName, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Write to file
    public static void writeFile(String fileName, Scanner scanner) throws IOException {
        System.out.print("Enter content to write: ");
        String content = scanner.nextLine();

        FileWriter writer = new FileWriter(fileName, true); // append mode
        writer.write(content + "\n");
        writer.close();
        System.out.println("Content written to " + fileName);
    }

    // Read from file
    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        System.out.println("File contents:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Modify file
    public static void modifyFile(String fileName, Scanner scanner) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        System.out.print("Enter the text to replace: ");
        String oldText = scanner.nextLine();
        System.out.print("Enter the new text: ");
        String newText = scanner.nextLine();

        StringBuilder fileContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.append(line.replaceAll(oldText, newText)).append("\n");
        }
        reader.close();

        FileWriter writer = new FileWriter(file);
        writer.write(fileContent.toString());
        writer.close();

        System.out.println("File modified successfully.");
    }
}
