/**
 * Represents a chat message with its associated sentiment score.
 * 
 * Precondition: None.
 * Postcondition: Chat entry class is ready to create instances.
 */
public class ChatEntry {
    protected String message;
    protected int sentimentScore;

    /**
     * Creates a new chat entry with the specified message and sentiment score.
     * 
     * Precondition: Message must not be null.
     * Postcondition: New ChatEntry object is created with specified message and score.
     * 
     * @param message -the chat message text
     * @param sentimentScore -the calculated sentiment score for the message
     */
    public ChatEntry(String message, int sentimentScore) {
        this.message = message;
        this.sentimentScore = sentimentScore;
    }

    /**
     * Returns the chat message.
     * 
     * Precondition: ChatEntry object must be initialized.
     * Postcondition: Message text is returned unchanged.
     * 
     * @return message -the chat message text
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the sentiment score.
     * 
     * Precondition: ChatEntry object must be initialized.
     * Postcondition: Sentiment score is returned unchanged.
     * 
     * @return sentimentScore -the sentiment score of the message
     */
    public int getSentimentScore() {
        return sentimentScore;
    }

    /**
     * Returns a string representation of the chat entry.
     * 
     * Precondition: ChatEntry object must be initialized.
     * Postcondition: String representation is created with message and score.
     * 
     * @return -string in format "message (Score: score)"
     */
    @Override
     public String toString() {
        return message + " (Score: " + sentimentScore + ")";
    }
} 