package LeetCode.TopInterviewQuestions;

import java.util.List;

public class Q19 {
    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    */

    public static int length;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthTargetFromEnd(head, 1, n);
    }

    public ListNode removeNthTargetFromEnd(ListNode head, int current, int target) {
        if (head.next == null) {
            length = current;
            if (target == 1) {
                return null;
            }
            return head;
        } else {
            ListNode node = removeNthTargetFromEnd(head.next, current + 1, target);
            if (length - current + 1 == target) {
                return node;
            } else {
                head.next = node;
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        Q19 q19 = new Q19();
        System.out.println(q19.removeNthFromEnd(listNode, 1));
    }
}
