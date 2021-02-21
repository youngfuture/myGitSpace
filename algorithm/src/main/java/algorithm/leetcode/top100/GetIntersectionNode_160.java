package main.java.algorithm.leetcode.top100;

//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAC = headA;
        ListNode headBC = headB;
        int countA = 0;
        int countB = 0;

        while (headAC != null) {
            headAC = headAC.next;
            countA++;
        }
        while (headBC != null) {
            headBC = headBC.next;
            countB++;
        }
        headAC = headA;
        headBC = headB;
        if (countB > countA) {
            for (int i = 0; i < countB - countA; i++) {
                headBC = headBC.next;
            }

        } else if (countB < countA) {
            for (int i = 0; i < countA - countB; i++) {
                headAC = headAC.next;
            }
        }

        while (headBC != null && headAC != null) {
            if (headAC == headBC) {
                return headAC;
            }
            headBC = headBC.next;
            headAC = headAC.next;
        }
        return null;

    }
}
