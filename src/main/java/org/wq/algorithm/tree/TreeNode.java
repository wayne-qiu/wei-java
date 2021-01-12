package org.wq.algorithm.tree;

public class TreeNode<T extends Comparable<?>> {
    TreeNode<T> left, right;
    T data;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
