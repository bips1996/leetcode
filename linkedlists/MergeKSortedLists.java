package linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    ListNode mergeKSortedList(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode templ1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode templ2 = l2;
        ListNode l3 = new ListNode(-1);
        ListNode templ3 = l3;

        int ctr1 = 1, ctr2 = 2, ctr3 = 3;

        for (int i = 1; i <= 5; i++) {
            ListNode temp = new ListNode(ctr1);
            templ1.next = temp;
            templ1 = templ1.next;

            ListNode temp2 = new ListNode(ctr2);
            templ2.next = temp2;
            templ2 = templ2.next;

            ListNode temp3 = new ListNode(ctr3);
            templ3.next = temp3;
            templ3 = templ3.next;

            ctr1 += 3;
            ctr2 += 4;
            ctr3 += 3;
        }

        ListNode[] lists = new ListNode[]{l1.next, l2.next, l3.next};
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode sortedList = mergeKSortedLists.mergeKSortedList(lists);
        while (sortedList != null) {
            System.out.println(sortedList.val);
            sortedList = sortedList.next;
        }


    }
}
