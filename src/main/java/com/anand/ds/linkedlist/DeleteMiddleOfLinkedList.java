package com.anand.ds.linkedlist;

/**
 * Given a singly linked list, delete the middle of the linked list.
 *
 * Note:
 *
 * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
 * If the input linked list has a single node, then it should return NULL.
 * Examples:
 *
 * Input: LinkedList: 1->2->3->4->5
 * Output: 1->2->4->5
 * Explanation:
 *
 * Input: LinkedList: 2->4->6->7->5->1
 * Output: 2->4->6->5->1
 * Explaination:
 *
 * Input: LinkedList: 7
 * Output: <empty linked list>
 * Explanation: There was only one node and it was deleted.
 */
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
 */
public class DeleteMiddleOfLinkedList {

    Node deleteMiddle(Node head) {
        // If there is only one node
        if(head.next == null){
            return null;
        }

        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Delete middle node by repointing
        prev.next = slow.next;
        return head;

    }

    public static void main(String[] args){
        DeleteMiddleOfLinkedList delete = new DeleteMiddleOfLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        delete.printList(head);
        head = delete.deleteMiddle(head);
        // Print Linked list now.
        delete.printList(head);


    }

    /**
     *
     * @param head
     */
    void printList(Node head){
        Node current = head;

        while(current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }
}
