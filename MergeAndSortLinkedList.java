class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeAndSortLinkedList {
    public static Node mergeLists(Node head1, Node head2) {
        Node mergedHead = new Node(-1);
        Node current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return mergedHead.next;
    }

    public static Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sortLinkedList(head);
        Node right = sortLinkedList(nextOfMiddle);

        return mergeSortedLists(left, right);
    }

    public static Node mergeSortedLists(Node head1, Node head2) {
        Node mergedHead = new Node(-1);
        Node current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return mergedHead.next;
    }

    public static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        // Sample input Linked-Lists
        Node head1 = new Node(25);
        head1.next = new Node(35);
        head1.next.next = new Node(12);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(36);
        head1.next.next.next.next.next = new Node(48);

        Node head2 = new Node(8);
        head2.next = new Node(32);
        head2.next.next = new Node(22);
        head2.next.next.next = new Node(45);
        head2.next.next.next.next = new Node(63);
        head2.next.next.next.next.next = new Node(49);

        // Merge the two linked lists
        Node mergedHead = mergeLists(head1, head2);

        // Sort the merged linked list
        Node sortedHead = sortLinkedList(mergedHead);

        // Print the sorted linked list
        System.out.print("Output: ");
        printLinkedList(sortedHead);
    }
}
