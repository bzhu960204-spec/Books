package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q206 {
    /*

    Given the head of a singly linked list, reverse the list, and return the reversed list.

    */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        List<ListNode> listNodes = new ArrayList<>();
        ListNode iterateNode = head;
        while (iterateNode != null) {
            listNodes.add(iterateNode);
            iterateNode = iterateNode.next;
        }
        for (int i = listNodes.size() - 1; i >= 0; i--) {
            if (i == 0) {
                listNodes.get(i).next = null;
            } else {
                listNodes.get(i).next = listNodes.get(i - 1);
            }
        }
        return listNodes.get(listNodes.size() - 1);
    }

    public ListNode iterateApproach(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode recursiveApproach1(ListNode head) {
        return recursive(head, null);
    }

    public ListNode recursive(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        } else {
            ListNode next = cur.next;
            cur.next = pre;
            return recursive(next, cur);
        }
    }

    public ListNode recursiveApproach2(ListNode head) {
        if (head == null) return null;
        ListNode headNode = head;
        if (head.next != null) {
            headNode = recursiveApproach2(head.next);
            head.next.next = head;
        }
        head.next = null;
        return headNode;
    }

    public static void main(String[] args) {

    }
}
