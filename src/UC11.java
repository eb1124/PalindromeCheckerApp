import java.util.Stack;

public class UC11{

    // Encapsulated method to check if a string is a palindrome
    public boolean checkPalindrome(String input) {
        // Normalize string: remove spaces and ignore case
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Use Stack internally for palindrome logic
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare stack pop with original normalized string
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        String test1 = "racecar";
        String test2 = "Hello";

        System.out.println("\"" + test1 + "\" is palindrome? " + checker.checkPalindrome(test1));
        System.out.println("\"" + test2 + "\" is palindrome? " + checker.checkPalindrome(test2));
    }
}