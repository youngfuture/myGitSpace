package algorithm.leetcode.top100.addTwoNumbers;


public class AddTwoNumbers_2 {


    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2, null);
        ListNode l1_2 = new ListNode(4, null);
        ListNode l1_3 = new ListNode(3, null);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5, null);
        ListNode l2_2 = new ListNode(6, null);
        ListNode l2_3 = new ListNode(4, null);
        l2_1.next = l2_2;
        l2_2.next = l2_3;


        new AddTwoNumbers_2().addTwoNumbers(l1_1, l2_1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        add(l1, l2, head);

        return head;

    }

    private void add(ListNode l1, ListNode l2, ListNode one) {
        if (l1 == null && l2 == null) {
            return;
        }

        int val1 = 0;
        if (l1 != null) {
            val1 = l1.val;
            l1 = l1.next;
        }

        int val2 = 0;
        if (l2 != null) {
            val2 = l2.val;
            l2 = l2.next;
        }


        if ((val1 + val2 + one.val) > 9) {
            one.val = val1 + val2 + one.val - 10;
            one.next = new ListNode(1, null);
        } else {
            one.val = val1 + val2 + one.val;
            one.next = new ListNode(0, null);
        }

        if (l1 == null && l2 == null) {
            if(one.next.val==0){
                one.next = null;
            }
            return;
        }

        one = one.next;

        add(l1, l2, one);
    }
}
