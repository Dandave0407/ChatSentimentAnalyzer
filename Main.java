import java.io.IOException;

/**
    Main class that serves as the entry point for the chat sentiment analysis program.
    Precondition: Java runtime environment must be properly set up.
    Postcondition: Program is ready to execute sentiment analysis on chat messages.
    */
public class Main {
    /**
        Executes the sentiment analysis on chat messages.
        Precondition: All input files must exist at specified paths with proper read/write permissions.
        Postcondition: Sentiment analysis is performed and results are written to output file.
        
        @param args -command line arguments (not used)
        @throws IOException -if there are issues reading from or writing to files
        */
    public static void main(String[] args) throws IOException {
        ChatAnalyzer analyzer = new ChatAnalyzer();
        analyzer.runAnalysis("/Users/danda/Downloads/messages.txt", "/Users/danda/Downloads/positive-words.txt", "/Users/danda/Downloads/negative-words.txt", "/Users/danda/Downloads/output.txt");
    }
}