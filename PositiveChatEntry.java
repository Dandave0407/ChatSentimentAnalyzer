/**
 * Represents a chat entry with a positive sentiment score.
 * 
 * Precondition: ChatEntry class must be defined.
 * Postcondition: PositiveChatEntry class is ready to create instances.
 */
public class PositiveChatEntry extends ChatEntry {
    /**
     * Creates a new positive chat entry.
     * 
     * Precondition: Message must not be null and sentiment score should be non-negative.
     * Postcondition: New PositiveChatEntry object is created with specified message and score.
     * 
     * @param message -the chat message text
     * @param sentimentScore -the positive sentiment score
     */
    public PositiveChatEntry(String message, int sentimentScore) {
        super(message, sentimentScore);
    }

    /**
     * Returns a string representation with [Positive] prefix.
     * 
     * Precondition: PositiveChatEntry object must be initialized.
     * Postcondition: String representation is created with [Positive] prefix.
     * 
     * @return -string in format "[Positive] message (Score: score)"
     */
    @Override
    public String toString() {
        return "[Positive] " + super.toString();
    }
} 