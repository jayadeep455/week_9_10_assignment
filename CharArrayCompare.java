import java.util.Scanner;

public class CharArrayCompare {

    // Method to convert String to char array manually
    public static char[] getCharsManually(String str) {
        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }

        return result;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // Method to print char array
    public static void printCharArray(char[] arr) {
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

        // User-defined method
        char[] manualArray = getCharsManually(text);

        // Built-in method
        char[] builtInArray = text.toCharArray();

        // Compare arrays
        boolean isSame = compareCharArrays(manualArray, builtInArray);

        // Output
        System.out.print("\nCharacters using manual method: ");
        printCharArray(manualArray);

        System.out.print("Characters using toCharArray(): ");
        printCharArray(builtInArray);

        if (isSame) {
            System.out.println("Both character arrays are SAME.");
        } else {
            System.out.println("Character arrays are DIFFERENT.");
        }

        sc.close();
    }
}