package org.wq.algorithm.tree;

public class MirrorTree {

    public void reverse(TreeNode node){

        if(node==null){
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        reverse(node.left);
        reverse(node.right);

    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<Integer>(1);
        TreeNode<Integer> n11 = new TreeNode<Integer>(2);
        TreeNode<Integer> n12 = new TreeNode<Integer>(3);
        TreeNode<Integer> n21 = new TreeNode<Integer>(4);
        TreeNode<Integer> n22 = new TreeNode<Integer>(5);
        TreeNode<Integer> n23 = new TreeNode<Integer>(6);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.left = n23;

        BTreePrinter.printNode(root);

        new MirrorTree().reverse(root);
        BTreePrinter.printNode(root);
    }
}
