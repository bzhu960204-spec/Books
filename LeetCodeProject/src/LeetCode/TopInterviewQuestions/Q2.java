package LeetCode.TopInterviewQuestions;

public class Q2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        System.out.println(Solution.addTwoNumbers(listNode, listNode2));
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode listNode = this;
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }

        return sb.toString();
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultLnode = new ListNode();
        ListNode returnResultNode = resultLnode;
        ListNode iteratel1 = new ListNode();
        ListNode iteratel2 = new ListNode();
        iteratel1.next = l1;
        iteratel2.next = l2;

        boolean addOne = false;

        while (iteratel1.next != null || iteratel2.next != null) {
            if (iteratel1.next == null) {
                iteratel2 = iteratel2.next;
                if (addOne) {
                    if ((iteratel2.val + 1) <= 9) {
                        addOne = false;
                        resultLnode.next = new ListNode(iteratel2.val + 1);
                    } else {
                        resultLnode.next = new ListNode(0);
                    }
                } else {
                    resultLnode.next = new ListNode(iteratel2.val);
                }
            } else if (iteratel2.next == null) {
                iteratel1 = iteratel1.next;
                if (addOne) {
                    if ((iteratel1.val + 1) <= 9) {
                        addOne = false;
                        resultLnode.next = new ListNode(iteratel1.val + 1);
                    } else {
                        resultLnode.next = new ListNode(0);
                    }
                } else {
                    resultLnode.next = new ListNode(iteratel1.val);
                }
            } else {
                iteratel1 = iteratel1.next;
                iteratel2 = iteratel2.next;
                if (addOne) {
                    if ((iteratel1.val + iteratel2.val + 1) <= 9) {
                        addOne = false;
                        resultLnode.next = new ListNode(iteratel1.val + iteratel2.val + 1);
                    } else {
                        resultLnode.next = new ListNode((iteratel1.val + iteratel2.val + 1) % 10);
                    }
                } else {
                    if ((iteratel1.val + iteratel2.val) > 9) {
                        addOne = true;
                        resultLnode.next = new ListNode((iteratel1.val + iteratel2.val) % 10);
                    } else {
                        resultLnode.next = new ListNode(iteratel1.val + iteratel2.val);
                    }
                }
            }
            resultLnode = resultLnode.next;
        }
        if (addOne) {
            resultLnode.next = new ListNode(1);
        }
        return returnResultNode.next;
    }
}
