class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC8 {

    // Helper method to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Method to check if linked list is palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // Compare both halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean isPalindrome = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Optional: Restore the original list
        slow.next = reverse(secondHalf);

        return isPalindrome;
    }

    public static void main(String[] args) {
        String input = "racecar";

        // Convert string to linked list
        Node head = new Node(input.charAt(0));
        Node current = head;
        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("The string \"" + input + "\" is a PALINDROME.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}