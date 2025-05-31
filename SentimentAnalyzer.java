import java.util.ArrayList;

/**
 * Analyzes text for sentiment using positive and negative word lists.
 * 
 * Precondition: None.
 * Postcondition: SentimentAnalyzer is ready to analyze text.
 */
public class SentimentAnalyzer {
    /**
     * Analyzes the sentiment of a message by comparing words against positive and negative lists.
     * 
     * Precondition: Message and word lists must not be null.
     * Postcondition: Returns sentiment score based on word matches.
     * 
     * @param message -the text to analyze
     * @param positiveWords -list of words indicating positive sentiment
     * @param negativeWords -list of words indicating negative sentiment
     * @return score -integer score (positive for positive sentiment, negative for negative sentiment)
     */
    public static int analyzeSentiment(String message, ArrayList<String> positiveWords, ArrayList<String> negativeWords) {
        String[] words = message.toLowerCase().split("\\s+");
        return analyzeSentimentR(words, 0, positiveWords, negativeWords);
    }

    /**
     * Recursively calculates sentiment score by processing one word at a time.
     * 
     * Precondition: Words array must not be null, index must be within bounds, word lists must not be null.
     * Postcondition: Returns cumulative sentiment score for remaining words.
     * 
     * @param words -array of words from the message
     * @param index -current position in the words array
     * @param positiveWords -list of words indicating positive sentiment
     * @param negativeWords -list of words indicating negative sentiment
     * @return score -cumulative sentiment score for the remaining words
     */
    private static int analyzeSentimentR(String[] words, int index, ArrayList<String> positiveWords, ArrayList<String> negativeWords) {
        if (index >= words.length) {
            return 0;
        }
        
        int currentScore = 0;
        if (positiveWords.contains(words[index])) currentScore = 1;
        else if (negativeWords.contains(words[index])) currentScore = -1;
        
        return currentScore + analyzeSentimentR(words, index + 1, positiveWords, negativeWords);
    }
} 