package linkedlists;

//https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(-1);
        ListNode temp = l0;
        for (int i = 1; i < 6; i++) {
            ListNode l = new ListNode(i);
            temp.next = l;
            temp = temp.next;
        }
        ListNode l2 = new ListNode(9);

        ListNode head = l0.next;

        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode res = obj.addTwoNumbers(head, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode op = temp;


        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 == null && l2 != null) {
                sum = l2.val + sum;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                sum = l1.val + sum;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + sum;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode l = new ListNode();
            l.val = sum % 10;
            op.next = l;
            op = op.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            ListNode c = new ListNode();
            c.val = carry;
            op.next = c;
        }

        return temp.next;
    }
}
