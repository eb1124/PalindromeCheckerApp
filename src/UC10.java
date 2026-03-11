public class UC10 {

    // Method to check palindrome ignoring case and spaces
    public static boolean isPalindrome(String str) {
        // Normalize: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        // Reverse the normalized string
        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed += normalized.charAt(i);
        }

        // Compare
        return normalized.equals(reversed);
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Check palindrome
        if (isPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a PALINDROME (case-insensitive & spaces ignored).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}