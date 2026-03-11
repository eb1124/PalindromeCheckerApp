import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=================================");
        System.out.println("        PALINDROME CHECKER       ");
        System.out.println("=================================");
        System.out.println("Version: 1.0");
        System.out.println("Welcome to the Palindrome Checker App!");
        System.out.println("---------------------------------");

        // Create scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string
        String reversed = "";
        for (int i = processed.length() - 1; i >= 0; i--) {
            reversed += processed.charAt(i);
        }

        // Check palindrome
        if (processed.equals(reversed)) {
            System.out.println("Result: The given string is a PALINDROME.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}