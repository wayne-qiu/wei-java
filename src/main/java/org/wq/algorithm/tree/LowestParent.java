package org.wq.algorithm.tree;

import java.util.Stack;

public class LowestParent {

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root , TreeNode<Integer> p , TreeNode<Integer> q) {
        Stack<TreeNode<Integer>> stackp = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stackq = new Stack<TreeNode<Integer>>();
        getPath(root , p , stackp);
        getPath(root , q , stackq);
        return lowestCommonAncestor(stackp , stackq);
    }

    private static TreeNode<Integer> lowestCommonAncestor(Stack<TreeNode<Integer>> stackp , Stack<TreeNode<Integer>> stackq) {
        TreeNode<Integer> target = null;
        while (!stackp.isEmpty() && !stackq.isEmpty() && stackp.peek() == stackq.peek()) {
            target = stackp.peek();
            stackp.pop();
            stackq.pop();
        }
        return target;
    }

    private static boolean getPath(TreeNode<Integer> root , TreeNode<Integer> p , Stack<TreeNode<Integer>> stackp) {
        // TODO Auto-generated method stub
        if (root == null)
            return false;
        if (root == p) {
            stackp.push(root);
            return true;
        } else {
            if (getPath(root.left , p , stackp) || getPath(root.right , p , stackp)) {
                stackp.push(root);
                return true;
            }
        }
        return false;
    }

    /***
     *
     * 这个代码在实现过程中，是当找到给定节点的时候才将路径依次压入stack中的，
     * 也就是说，两个stack的栈顶都是存放着root节点。
     * 因此，此时就应该找两条路径分离开之前的最后一个节点，
     * 此节点就是所求的最低公共祖先。
     * @param args
     */

    public static void main(String args[]) {
        TreeNode<Integer> n1 = new TreeNode<Integer>();
        TreeNode<Integer> n2 = new TreeNode<Integer>();
        TreeNode<Integer> n3 = new TreeNode<Integer>();
        TreeNode<Integer> n4 = new TreeNode<Integer>();
        TreeNode<Integer> n5 = new TreeNode<Integer>();
        TreeNode<Integer> n6 = new TreeNode<Integer>();
        TreeNode<Integer> n7 = new TreeNode<Integer>();

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.data = 1;
        n2.data = 2;
        n3.data = 3;
        n4.data = 4;
        n5.data = 5;
        n6.data = 6;
        n7.data = 7;
        // 搜索二叉树
        //            1
        //          /   \
        //         2     3
        //        / \   / \
        //      4    5 6   7
        System.out.println(n1.data);
        System.out.println(n6.data);
        System.out.println(n7.data);
        TreeNode<Integer> parent = lowestCommonAncestor(n1 , n6 , n7);
        System.out.println(parent.data);
    }


}