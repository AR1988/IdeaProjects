package com.company;

import java.util.TreeSet;

public class OurTree extends TreeSet {

    TreeNode root;

    public int size() {
        return recursiveSizeOptimal(root);
    }

    private int recursiveSize(TreeNode node) {
        if (node.left == null && node.right == null)
            return 1;

        if (node.left == null)
            return 1 + recursiveSize(node.right);

        if (node.right == null) {
            return 1 + recursiveSize(node.left);
        }

        return 1 + recursiveSize(node.left) + recursiveSize(node.right);

    }

    private int recursiveSizeOptimal(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + recursiveSizeOptimal(node.left) + recursiveSizeOptimal(node.right);
    }

    public int height() {
        return recursiveHeight(root);
    }

    private int recursiveHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(recursiveHeight(node.left), recursiveHeight(node.right));
    }
}
