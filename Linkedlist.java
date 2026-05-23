import java.util.Scanner;

public class Linkedlist {

    // 1. Define the custom structural building block from scratch
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements to add to the LinkedList: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input count.");
            sc.close();
            return;
        }
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("The list is empty. No middle node exists.");
            sc.close();
            return;
        }

        System.out.println("Enter " + n + " integers to populate the list:");

        // Read the first element to initialize our head pointer boundary
        Node head = new Node(sc.nextInt());
        Node current = head;

        // Append remaining nodes sequentially from scratch
        for (int i = 1; i < n; i++) {
            int val = sc.nextInt();
            current.next = new Node(val);
            current = current.next;
        }

        // Display the constructed chain configuration to verify structural accuracy
        System.out.print("\nYour LinkedList: ");
        printList(head);

        // 2. Compute the middle node reference using the pointer strategy
        Node middleNode = findMiddle(head);

        // Print the result value
        System.out.println("The data at the middle node is: " + middleNode.data);

        sc.close();
    }

    // Two-Pointer Middle Node Discovery Engine
    private static Node findMiddle(Node head) {
        // Base Case: If the list has 0 or 1 nodes, head is natively the middle node
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        // Advance fast by 2 steps and slow by 1 step.
        // Check fast.next for odd lengths and fast.next.next for even lengths.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow pointer is now verified to be resting on the exact median coordinate
        return slow;
    }

    // Helper method to display our nodes cleanly in the console terminal
    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
