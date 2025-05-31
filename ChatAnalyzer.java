import java.io.IOException;
import java.util.ArrayList;

/**
 * Analyzes chat messages for sentiment and categorizes them as positive or negative.
 * 
 * Precondition: System must have access to file system and sufficient memory.
 * Postcondition: Chat analyzer is ready to process messages.
 */
public class ChatAnalyzer {
    /**
     * Runs sentiment analysis on messages using positive and negative word lists.
     * 
     * Precondition: All input files must exist and be accessible with proper permissions.
     * Postcondition: Messages are analyzed, sorted, and written to output file.
     * 
     * @param messageFile -path to file containing messages to analyze
     * @param positiveFile -path to file containing positive words
     * @param negativeFile -path to file containing negative words
     * @param outputFile -path where results will be written
     * @throws IOException -if there are issues reading from or writing to files
     */
    public void runAnalysis(String messageFile, String positiveFile, String negativeFile, String outputFile) throws IOException {
        ArrayList<String> positiveWords = FileManager.readWordList(positiveFile);
        ArrayList<String> negativeWords = FileManager.readWordList(negativeFile);

        ArrayList<ChatEntry> entries = FileManager.readMessages(messageFile);
        processEntriesRecursively(entries, 0, positiveWords, negativeWords);
        entries = Sorter.mergeSort(entries);
        FileManager.writeMessages(outputFile, entries);
    }

    /**
     * Recursively processes chat entries to determine their sentiment.
     * 
     * Precondition: Entries list and word lists must be initialized and not null.
     * Postcondition: Each entry is processed and converted to appropriate sentiment type.
     * 
     * @param entries -list of chat entries to process
     * @param index -current position in the entries list
     * @param positiveWords -list of words indicating positive sentiment
     * @param negativeWords -list of words indicating negative sentiment
     */
    private void processEntriesRecursively(ArrayList<ChatEntry> entries, int index, ArrayList<String> positiveWords, ArrayList<String> negativeWords) {
        if (index >= entries.size()) {
            return;
        }

        ChatEntry entry = entries.get(index);
        int score = SentimentAnalyzer.analyzeSentiment(entry.getMessage(), positiveWords, negativeWords);
        ChatEntry newEntry;
        if (score >= 0) {
            newEntry = new PositiveChatEntry(entry.getMessage(), score);
        } else {
            newEntry = new NegativeChatEntry(entry.getMessage(), score);
        }
        entries.set(index, newEntry);

        processEntriesRecursively(entries, index + 1, positiveWords, negativeWords);
    }
} 