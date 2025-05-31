/**
 * Represents a chat entry with a negative sentiment score.
 * 
 * Precondition: ChatEntry class must be defined.
 * Postcondition: NegativeChatEntry class is ready to create instances.
 */
public class NegativeChatEntry extends ChatEntry {
    /**
     * Creates a new negative chat entry.
     * 
     * Precondition: Message must not be null and sentiment score should be negative.
     * Postcondition: New NegativeChatEntry object is created with specified message and score.
     * 
     * @param message -the chat message text
     * @param sentimentScore -the negative sentiment score
     */
    public NegativeChatEntry(String message, int sentimentScore) {
        super(message, sentimentScore);
    }

    /**
     * Returns a string representation with [Negative] prefix.
     * 
     * Precondition: NegativeChatEntry object must be initialized.
     * Postcondition: String representation is created with [Negative] prefix.
     * 
     * @return -string in format "[Negative] message (Score: score)"
     */
    @Override
    public String toString() {
        return "[Negative] " + super.toString();
    }
} 