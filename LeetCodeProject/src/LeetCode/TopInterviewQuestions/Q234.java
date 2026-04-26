package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q234 {
    /*

    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

    */
    public boolean isPalindrome(ListNode head) {
        List<ListNode> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }
        for (int i = 0; i <= arrayList.size() / 2; i++) {
            if (arrayList.get(i).val != arrayList.get(arrayList.size() - 1 - i).val) {
                return false;
            }
        }
        return true;
    }
}
