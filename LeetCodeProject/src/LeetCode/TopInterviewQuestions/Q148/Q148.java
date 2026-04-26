package LeetCode.TopInterviewQuestions.Q148;

import java.util.*;

public class Q148 {
    /*

    Given the head of a linked list, return the list after sorting it in ascending order.

    */

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>() {{
            add(3);
            add(2);
            add(9);
        }};
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }


    public ListNode sortList_mysolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode iterateNode = head;
        List<ListNode> listNodeList = new ArrayList<>();
        while (iterateNode != null) {
            listNodeList.add(new ListNode(iterateNode.val));
            iterateNode = iterateNode.next;
        }
        listNodeList.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < listNodeList.size(); i++) {
            if (i == listNodeList.size() - 1) {
                listNodeList.get(i).next = null;
            } else {
                listNodeList.get(i).next = listNodeList.get(i + 1);
            }
        }
        return listNodeList.get(0);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode right = getMid(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(right);


        return merge(list1, list2);
    }

    ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
