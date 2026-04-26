package LeetCode.TopInterviewQuestions.Q155;

public class Q155 {
    /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.


    ["MinStack","push","push","push","getMin","top","pop","getMin"]
    [[],[-2],[0],[-1],[],[],[],[]]

    */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    ListNode head;

    ListNode minHead;

    public MinStack() {

    }

    public void push(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        head = listNode;
        if (minHead == null || val < minHead.val) {
            ListNode newMin = new ListNode(val);
            newMin.next = minHead;
            minHead = newMin;
        }else{
            ListNode newMin = new ListNode(minHead.val);
            newMin.next = minHead;
            minHead = newMin;
        }
    }

    public void pop() {
        ListNode dummy = head;
        head = head.next;
        dummy.next = null;
        ListNode dummy2 = minHead;
        minHead = minHead.next;
        dummy2.next = null;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minHead.val;
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