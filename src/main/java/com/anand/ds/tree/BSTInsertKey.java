package com.anand.ds.tree;

/**
 * Given the root of a Binary Search Tree (BST) and an integer key, insert a new node with value key into the BST. Return the root of the modified tree after the insertion.
 * Note: All the nodes have distinct values in the BST and the new value to be inserted is not present in the BST.
 * Examples :
 * Input: root = [2, 1, 3], key = 4
 * Output: [2, 1, 3, N, N, N, 4]
 * Explanation: After inserting the node 4, the new tree will be [2, 1, 3, N, N, N, 4].
 */
public class BSTInsertKey {
    public Node insertIntoBST(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insertIntoBST(root.left, key);
        } else {
            root.right = insertIntoBST(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        BSTInsertKey bstInsertKey = new BSTInsertKey();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        int key = 4;
        Node newRoot = bstInsertKey.insertIntoBST(root, key);
        System.out.println("New root after insertion: " + newRoot.data); // Output: 2
    }
}
