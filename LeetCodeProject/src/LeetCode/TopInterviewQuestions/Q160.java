package LeetCode.TopInterviewQuestions;

public class Q160 {
    /*
    Given the heads of two singly linked-lists headA and headB,

    return the node at which the two lists intersect.

    If the two linked lists have no intersection at all, return null.

    0
[2,6,4]
[1,5]
3
2

    */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                l1 = headB;
                headB = null;
            }
            if (l2 == null) {
                l2 = headA;
                headA = null;
            }
        }
        return l1;
    }
}
