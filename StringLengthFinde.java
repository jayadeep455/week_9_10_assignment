import java.util.Scanner;

public class StringLengthFinder {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;

        try {
            // Infinite loop until exception occurs
            while (true) {
                str.charAt(count); // Access character
                count++;           // Increment count
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Using user-defined method
        int manualLength = findLength(text);

        // Using built-in method
        int actualLength = text.length();

        // Output
        System.out.println("\nLength using custom method: " + manualLength);
        System.out.println("Length using length(): " + actualLength);

        if (manualLength == actualLength) {
            System.out.println("Both results are SAME.");
        } else {
            System.out.println("Results are DIFFERENT.");
        }

        sc.close();
    }
}