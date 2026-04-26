package LeetCode.TopInterviewQuestions;

public class Q21 {
    /*

    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.

    * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyResult;
        ListNode resultList = new ListNode();
        dummyResult = resultList;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                resultList.next = list2;
                list2 = list2.next;

                resultList = resultList.next;
                continue;
            } else if (list2 == null) {
                resultList.next = list1;
                list1 = list1.next;

                resultList = resultList.next;
                continue;
            }
            if (list1.val < list2.val) {
                resultList.next = list1;
                list1 = list1.next;

                resultList = resultList.next;
            } else {
                resultList.next = list2;
                list2 = list2.next;

                resultList = resultList.next;
            }
        }
        return dummyResult.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        Q21 q21 = new Q21();
        System.out.println(q21.mergeTwoLists(listNode1, listNode4));

    }
}
