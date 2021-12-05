package algorithm.offer;


//剑指 Offer 25. 合并两个排序的链表
public class MergeTwoLists_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        //输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4

        ListNode first;
        ListNode second;
        if (l1.val <= l2.val) {
            first = l1;
            second = l2;
        } else {
            first = l2;
            second = l1;
        }


        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (first != null && second != null && first.val <= second.val) {
            pre.next = first;
            first = first.next;
            pre = pre.next;
            while (first != null && second != null && first.val >= second.val) {
                pre.next = second;
                second = second.next;
                pre = pre.next;
            }
        }

        //[-10,-9,-6,-4,1,9,9]
        //[-5,-3,0,7,8,8]

        if (first == null) {
            pre.next = second;
        }
        if (second == null) {
            pre.next = first;
        }

        return head.next;


    }
}
