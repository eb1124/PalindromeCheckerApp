import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Concrete Strategy 1: Stack-based
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Concrete Strategy 2: Deque-based
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    // Inject strategy dynamically
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        if (strategy == null) throw new IllegalStateException("Strategy not set");
        return strategy.isPalindrome(input);
    }
}

// Demo Application
public class UC12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("Enter a string to check:");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = sc.nextInt();

        // Inject strategy dynamically
        switch (choice) {
            case 1 -> context.setStrategy(new StackStrategy());
            case 2 -> context.setStrategy(new DequeStrategy());
            default -> {
                System.out.println("Invalid choice!");
                sc.close();
                return;
            }
        }

        // Execute selected strategy
        boolean result = context.executeStrategy(input);
        System.out.println("\"" + input + "\" is palindrome? " + result);

        sc.close();
    }
}