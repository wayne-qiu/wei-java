package org.wq.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class CertainSumPath {

    public void BackTrack(List<TreeNode> path, TreeNode<Integer> node, int sum, int target){
        if(node == null){
            return;
        }

        path.add(node);

        if(sum+node.data < target) {
            sum += node.data;
            BackTrack(path, node.left, sum, target);
            BackTrack(path, node.right, sum, target);
        }

        if(sum+node.data==target){
            System.out.println(path);
        }
        // back
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        TreeNode<Integer> n11 = new TreeNode<Integer>(2);
        TreeNode<Integer> n12 = new TreeNode<Integer>(3);
        TreeNode<Integer> n21 = new TreeNode<Integer>(4);
        TreeNode<Integer> n22 = new TreeNode<Integer>(5);
        TreeNode<Integer> n23 = new TreeNode<Integer>(6);
        TreeNode<Integer> n24 = new TreeNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.left = n23;
        n12.right = n24;

        BTreePrinter.printNode(root);

        new CertainSumPath().BackTrack(new ArrayList<>(), root, 0, 8);
    }
}
