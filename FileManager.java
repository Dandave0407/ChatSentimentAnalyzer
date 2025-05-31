import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages file operations for reading word lists and messages, and writing results.
 * 
 * Precondition: File system must be accessible with appropriate permissions.
 * Postcondition: FileManager is ready to perform file operations.
 */
public class FileManager {
    /**
     * Reads a list of words from a file, converting them to lowercase.
     * 
     * Precondition: File must exist and be readable.
     * Postcondition: Words are read from file and returned in lowercase.
     * 
     * @param fileName -path to the file containing words
     * @return words -ArrayList of words in lowercase
     * @throws FileNotFoundException -if the file cannot be found or accessed
     */
    public static ArrayList<String> readWordList(String fileName) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase();
            if (!line.isEmpty()) {
                words.add(line);
            }
        }
        sc.close();
        return words;
    }

    /**
     * Reads messages from a file and creates ChatEntry objects.
     * 
     * Precondition: File must exist and be readable.
     * Postcondition: Messages are read and converted to ChatEntry objects.
     * 
     * @param fileName -path to the file containing messages
     * @return entries -ArrayList of ChatEntry objects
     * @throws FileNotFoundException -if the file cannot be found or accessed
     */
    public static ArrayList<ChatEntry> readMessages(String fileName) throws FileNotFoundException {
        ArrayList<ChatEntry> entries = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                entries.add(new ChatEntry(line, 0));
            }
        }
        sc.close();
        return entries;
    }

    /**
     * Writes chat entries to a file.
     * 
     * Precondition: Output directory must exist and be writable, entries list must not be null.
     * Postcondition: All entries are written to the file.
     * 
     * @param fileName -path where the file should be written
     * @param entries -list of ChatEntry objects to write
     * @throws IOException -if there are issues writing to the file
     */
    public static void writeMessages(String fileName, ArrayList<ChatEntry> entries) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (ChatEntry entry : entries) {
            writer.write(entry.toString() + "\n");
        }
        writer.close();
    }
} 