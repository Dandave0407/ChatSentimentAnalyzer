import java.util.ArrayList;

/**
    Provides merge sort functionality for ChatEntry objects based on sentiment scores.
    Precondition: None.
    Postcondition: Sorter is ready to sort lists of ChatEntry objects.
    */
public class Sorter {
    /**
        Sorts a list of ChatEntry objects using merge sort algorithm.
        Precondition: Input list must not be null.
        Postcondition: Returns a new sorted list, original list remains unchanged.
        
        @param list -list of ChatEntry objects to sort
        @return sortedList -new sorted ArrayList of ChatEntry objects
        */
    public static ArrayList<ChatEntry> mergeSort(ArrayList<ChatEntry> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        ArrayList<ChatEntry> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<ChatEntry> right = new ArrayList<>(list.subList(mid, list.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    /**
        Merges two sorted lists of ChatEntry objects.
        Precondition: Both input lists must be sorted and not null.
        Postcondition: Returns a new merged and sorted list, input lists remain unchanged.
        
        @param left -first sorted list of ChatEntry objects
        @param right -second sorted list of ChatEntry objects
        @return mergedList -new merged and sorted ArrayList of ChatEntry objects
        */
    private static ArrayList<ChatEntry> merge(ArrayList<ChatEntry> left, ArrayList<ChatEntry> right) {
        ArrayList<ChatEntry> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getSentimentScore() <= right.get(j).getSentimentScore()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }
} 