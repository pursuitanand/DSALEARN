package com.anand.ds.linkedlist;

/**
 * You are given the head of a linked list, You have to return the value of the middle node of the linked list.
 *
 * If the number of nodes is odd, return the middle node value.
 * If the number of nodes is even, there are two middle nodes, so return the second middle node value.
 * Examples:
 *
 * Input: 1->2->3->4->5-null
 *
 * Output: 3
 * Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
 *
 * Input: 2->4->6->7->5->1 - null
 *
 * Output: 7
 * Explanation: The given linked list is 2->4->6->7->5->1 so, there are two middle node 6 and 7, return the second middle node as 7.
 *
 */
/**
 * Expected Complexities
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
/**
 * Algorithm: Slow and Fast Pointer technique
 * KEY IS "when Fast has traveled the entire list, Slow has traveled approximately half of the list."
 * 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
 * 2. Move the fast pointer two steps for every one step the slow pointer takes.
 * 3. When the fast pointer reaches the end of the list (null), the slow pointer will be at the middle node.
 * 4. Return the value of the slow pointer.
 */


class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
public class MiddleOfLinkedList {

    int getMiddle(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow pointer by 1 step
            fast = fast.next.next; // move fast pointer by 2 steps
        }
        return slow.data; // slow pointer is now at the middle node
    }

    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Middle of linked list: " + middleOfLinkedList.getMiddle(head)); // Output: 3

        head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(1);
        System.out.println("Middle of linked list: " + middleOfLinkedList.getMiddle(head)); // Output: 7
    }
}
