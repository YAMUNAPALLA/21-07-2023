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
class swapPairsSolution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = (ListNode) head.next;

            // Swapping the nodes
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move to the next pair
            prev = firstNode;
            head = (ListNode) firstNode.next;
        }

        return (ListNode) dummy.next;
    }
}
