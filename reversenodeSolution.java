/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class reversenodeSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        // Count the number of nodes in the current group
        while (current != null && count < k) {
            current = (ListNode) current.next;
            count++;
        }

        // If there are at least k nodes, reverse the current group
        if (count == k) {
            current = reverseKGroup(current, k); // Recursive call on the next group

            // Reverse the current group of k nodes
            while (count-- > 0) {
                ListNode nextNode = (ListNode) head.next;
                head.next = current;
                current = head;
                head = nextNode;
            }

            head = current;
        }

        return head;
    }
}
