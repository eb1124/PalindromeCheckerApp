import java.util.*;

public class UC13 {

    // Stack-based approach
    public static boolean stackPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }

    // Deque-based approach
    public static boolean dequePalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // Recursive approach
    public static boolean recursivePalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return recursiveHelper(normalized, 0, normalized.length() - 1);
    }

    private static boolean recursiveHelper(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveHelper(str, start + 1, end - 1);
    }

    // Char array approach
    public static boolean charArrayPalindrome(String input) {
        char[] chars = input.replaceAll("\\s+", "").toLowerCase().toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to test performance: ");
        String input = sc.nextLine();

        // Stack
        long start = System.nanoTime();
        stackPalindrome(input);
        long end = System.nanoTime();
        System.out.println("Stack approach: " + (end - start) + " ns");

        // Deque
        start = System.nanoTime();
        dequePalindrome(input);
        end = System.nanoTime();
        System.out.println("Deque approach: " + (end - start) + " ns");

        // Recursive
        start = System.nanoTime();
        recursivePalindrome(input);
        end = System.nanoTime();
        System.out.println("Recursive approach: " + (end - start) + " ns");

        // Char array
        start = System.nanoTime();
        charArrayPalindrome(input);
        end = System.nanoTime();
        System.out.println("Char array approach: " + (end - start) + " ns");

        sc.close();
    }
}