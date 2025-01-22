package linkedlists;

//https://leetcode.com/problems/sort-list/

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoLists(left, right);

    }

    public ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode l0 = new ListNode(-1);
        ListNode temp = l0;
        for (int i = 9; i > 1; i--) {
            ListNode l = new ListNode(i);
            temp.next = l;
            temp = temp.next;
        }
        ListNode head = l0.next;

        ListNode result = sortList.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
