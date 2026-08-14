package com.anand.ds.tree;

/**
 * Given a root of a Binary Tree, your task is to return its Inorder Traversal.
 * Note: An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).
 * Examples:
 * Input: root = [1, 2, 3, 4, 5]
 * Output: [4, 2, 5, 1, 3]
 * Explanation: The inorder traversal of the given binary tree is [4, 2, 5, 1, 3].
 * Input: root = [8, 1, 5, N, 7, 10, 6, N, 10, 6]
 * Output: [1, 7, 10, 8, 6, 10, 5, 6]
 * Explanation: The inorder traversal of the given binary tree is [1, 7, 10, 8, 6, 10, 5, 6].
 */

import java.util.ArrayList;

/**
 * Expected Complexities
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 * inorder = Left → Node or Root → Right :: recursion works I come IN BETWEEN.
 * For every node, we want to do exactly this:
 * 1. Process my LEFT subtree
 * 2. Process MYSELF
 * 3. Process my RIGHT subtree
 */

/* Structure of Binary Tree Node */
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
public class BinaryTreeInOrderTraversal {

    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        // Traverse the left subtree
        inorder(root.left, result);
        // Visit the current node
        result.add(root.data);
        // Traverse the right subtree
        inorder(root.right, result);
    }

    /**
     * Definition	null	Formula	Leaf
     * Height = nodes	0	1 + max(L,R)	1
     * Height = edges	-1	1 + max(L,R)	0
     * @param root
     * @return
     */
    public int height(Node root) {
        if (root == null) {
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeInOrderTraversal tree = new BinaryTreeInOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> result = tree.inOrder(root);
        System.out.println("Inorder Traversal: " + result); // Output: [4, 2, 5, 1, 3]

        System.out.println("Height of the tree: " + tree.height(root)); // Output: 2
    }
}
