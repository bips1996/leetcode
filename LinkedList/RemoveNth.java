package LinkedList;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNth {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(-1);
        ListNode temp = l0;
        for (int i = 1; i < 6; i++) {
            ListNode l = new ListNode(i);
            temp.next = l;
            temp = temp.next;
        }
        ListNode head = l0.next;
        
        RemoveNth obj = new RemoveNth();
        obj.removeNthNode(head, 2);
    }

    public ListNode removeNthNode(ListNode head, int n) {
        if (n == 1) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            System.out.println("s = " + slow.val + "f = ");
        }

        slow.next = slow.next.next;
        return head;
    }
}
