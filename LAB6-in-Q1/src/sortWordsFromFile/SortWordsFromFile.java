package sortWordsFromFile;

import java.io.*;
import java.util.*;

public class SortWordsFromFile {
    public static void main(String[] args) {
        // File path
        String filePath = "text.txt";  // Replace with your file path
        
        try {
            // Step 1: Read the text from the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");  // Read the entire paragraph
            }
            reader.close();

            // Step 2: Extract words from the paragraph
            String paragraph = content.toString();
            String[] words = paragraph.split("\\W+");  // Split by non-word characters

            // Step 3: Bubble Sort to sort words alphabetically
            bubbleSort(words);

            // Step 4: Display the sorted list of words
            System.out.println("Sorted Words:");
            for (String word : words) {
                System.out.println(word);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Bubble Sort Algorithm to sort the array of words
    public static void bubbleSort(String[] words) {
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words[j].compareToIgnoreCase(words[j + 1]) > 0) {
                    // Swap words[j] and words[j+1]
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }
}
