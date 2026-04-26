package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * definitely not the best solution
 */
public class Q138 {

    /*
    A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

    For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

    Return the head of the copied linked list.

    The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
    Your code will only be given the head of the original linked list.

     */
    public Node copyRandomList_mySolution(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        List<Node> newNodeList = new ArrayList<>();
        for (Node node : nodeList) {
            Node newNode = new Node(node.val);
            newNodeList.add(newNode);
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (i != nodeList.size() - 1) {
                newNodeList.get(i).next = newNodeList.get(i + 1);
            }
            if (nodeList.get(i).random == null) {
                newNodeList.get(i).random = null;
            } else {
                newNodeList.get(i).random = newNodeList.get(returnIndexOfNode(nodeList, nodeList.get(i).random));
            }
        }
        return newNodeList.get(0);
    }

    int returnIndexOfNode(List<Node> nodeList, Node node) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) == node) {
                return i;
            }
        }
        return -1;
    }

    public Node copyRandomList_onlineSolution(Node head) {
        Map<Node, Node> nodeNodeHashMap = new HashMap<>();
        nodeNodeHashMap.put(null, null);
        Node curr = head;
        while (curr != null) {
            nodeNodeHashMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            nodeNodeHashMap.get(curr).next = nodeNodeHashMap.get(curr.next);
            nodeNodeHashMap.get(curr).random = nodeNodeHashMap.get(curr.random);
            curr = curr.next;
        }
        return nodeNodeHashMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
