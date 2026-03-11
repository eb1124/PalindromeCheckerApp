public class UC9 {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: single character or empty substring
        if (start >= end) {
            return true;
        }

        // Compare first and last characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam";

        // Call recursive palindrome checker
        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The string \"" + input + "\" is a PALINDROME.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}