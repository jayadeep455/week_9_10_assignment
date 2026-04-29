import java.util.Scanner;

public class SplitTextCompare {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End reached
        }
        return count;
    }

    // Method to split text manually using charAt()
    public static String[] splitText(String text) {
        int length = findLength(text);

        // Step 1: Count words (spaces + 1)
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Step 3: Extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            words[i] = "";

            for (int j = start; j < end; j++) {
                words[i] += text.charAt(j);
            }

            start = end + 1;
        }

        // Last word
        words[wordCount - 1] = "";
        for (int j = start; j < length; j++) {
            words[wordCount - 1] += text.charAt(j);
        }

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    // Method to print array
    public static void printArray(String[] arr) {
        for (String word : arr) {
            System.out.print(word + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Manual split
        String[] manualWords = splitText(text);

        // Built-in split
        String[] builtInWords = text.split(" ");

        // Compare
        boolean isSame = compareArrays(manualWords, builtInWords);

        // Output
        System.out.print("\nManual split: ");
        printArray(manualWords);

        System.out.print("Built-in split: ");
        printArray(builtInWords);

        if (isSame) {
            System.out.println("Both results are SAME.");
        } else {
            System.out.println("Results are DIFFERENT.");
        }

        sc.close();
    }
}