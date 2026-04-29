import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int length = findLength(text);

        // Step 1: Temporary array to store unique chars
        char[] temp = new char[length];
        int uniqueCount = 0;

        // Step 2: Find unique characters using nested loop
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Compare with previous characters
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, store it
            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }

        // Step 3: Create final array of exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Method to print char array
    public static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Find unique characters
        char[] uniqueChars = findUniqueChars(text);

        // Output
        System.out.print("\nUnique characters: ");
        printArray(uniqueChars);

        sc.close();
    }
}