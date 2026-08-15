package com.anand.ds.tree;

/**
 * Given the root of a Binary Search Tree (BST) with unique node values and two nodes n1 and n2 (n1 != n2), find their Lowest Common Ancestor (LCA).
 * The Lowest Common Ancestor (LCA) of two nodes is defined as the deepest node in the tree that has both n1 and n2 as descendants, where a node can be a descendant of itself.
 * Examples:
 * Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1->data = 7, n2->data = 8
 * Output: 7
 * Explanation: 7 is the lowest node that has both 7 and 8 as descendants.
 */
public class LowestCommonAncestorInBST {

    public Node lowestCommonAncestor(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left subtree
        if (n1.data < root.data && n2.data < root.data) {
            return lowestCommonAncestor(root.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right subtree
        if (n1.data > root.data && n2.data > root.data) {
            return lowestCommonAncestor(root.right, n1, n2);
        }

        // If one of n1 or n2 is on one side and the other is on the other side, then root is the LCA
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorInBST lcaFinder = new LowestCommonAncestorInBST();
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        Node n1 = root.right.right; // Node with value 7
        Node n2 = root.right.right.right; // Node with value 8

        Node lca = lcaFinder.lowestCommonAncestor(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1.data + " and " + n2.data + " is: " + lca.data); // Output: 7
    }
}
