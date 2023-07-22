class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesFromLinkedList {
    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node prev = null;
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample input Linked-List
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(12);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next.next.next = new Node(5);

        // Remove duplicates from the linked list
        Node newHead = removeDuplicates(head);

        // Print the modified linked list
        System.out.print("Output: ");
        printLinkedList(newHead);
    }
}
