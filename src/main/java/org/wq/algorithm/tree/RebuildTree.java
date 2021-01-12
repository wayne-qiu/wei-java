package org.wq.algorithm.tree;

public class RebuildTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root =re(pre,0,pre.length-1,in,0,in.length-1);//传入前序遍历和中序遍历的序列，返回还原的二叉树。
        return root;
    }

    public TreeNode re(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre||startIn>endIn){//判定是否序列是否便利完。
            return null;
        }
        TreeNode root =new TreeNode(pre[startPre]);//存入节点
        for(int i=startIn;i<=endIn;i++){//从中序遍历开始，寻找和根节点相同的元素。
            if(in[i]==pre[startPre]){//找到了之后分为左右子树，递归进行查找。
                root.left=re(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=re(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,8,5,4,10,20,15,7};
        int[] inorder = new int[]{4,5,8,10,9,3,15,20,7};

        BTreePrinter.printNode(new RebuildTree().reConstructBinaryTree(preorder, inorder));
    }
}

