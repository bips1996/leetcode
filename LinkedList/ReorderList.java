package LinkedList;
//https://leetcode.com/problems/reorder-list/submissions/1501592406/

public class ReorderList {
    public static void main(String[] args) {
      ListNode l0 = new ListNode(-1);
      ListNode temp = l0;
      for(int i =1;i<5;i++) {
        ListNode l = new ListNode(i);
        temp.next = l;
        temp = temp.next;
      }
      ListNode head = l0.next;
      ReorderList rl = new ReorderList();
      rl.reOrderList(head);

        while(head != null) {
        System.out.println(head.val);
        head = head.next;
        }
    }

    private void reOrderList(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;

      while(fast != null && fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode temp = slow;
      ListNode reversed = reverseList(slow.next);
      temp.next = null;


      while(reversed != null) {
        ListNode temp1  = head.next;
        ListNode temp2 = reversed.next;
        head.next = reversed;
        reversed.next = temp1;
        reversed = temp2;
        head = temp1;
      }

    }

    private ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode next = null;

      while(head !=null) {
        next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }

      return prev;

    }
}
