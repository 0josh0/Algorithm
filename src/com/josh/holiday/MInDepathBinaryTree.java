package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 求二叉树的最小深度
 * 分析: 深度优先遍历
 * 
 */
public class MInDepathBinaryTree {
    public int minDepth(TreeNode root) {
    	if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        else return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
	@Test
	public void test(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
	
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n4.right=n7;
		System.out.println(minDepth(n1));
	}
}
