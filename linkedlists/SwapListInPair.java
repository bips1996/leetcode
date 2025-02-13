package linkedlists;

public class SwapListInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head.next;
        ListNode prev = new ListNode(-1);

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;

            head = head.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        for (int i = 1; i <= 7; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = new SwapListInPair().swapPairs(head.next);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }


}
