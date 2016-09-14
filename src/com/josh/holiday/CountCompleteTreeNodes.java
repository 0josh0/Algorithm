package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：给定一颗完全二叉树，计算完全二叉树的结点个数
 * 分析：递归求解，首先从当前根节点向左和向右遍历，如果左侧和右侧高度相等，直接返回节点数，2<<level-1，（一定要用位操作，否则超时）
 *      然后对左右子树递归求解
 */
public class CountCompleteTreeNodes {
	@Test
	public void test(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		n4.left=n8;
		n4.right=n9;
		n5.left=n10;
		n5.right=n11;
		n6.left=n12;
		n6.right=n13;
		int res = countNodes(n1);
		System.out.println(res);
	}
    public int countNodes(TreeNode root) {
    	if(root==null) return 0;
    	int lLevel=0,rLevel=0;
    	TreeNode lRoot=root,rRoot=root;
    	while(lRoot!=null){
    		lLevel++;
    		lRoot=lRoot.left;
    	}
    	while(rRoot!=null){
    		rLevel++;
    		rRoot=rRoot.right;
    	}
    	if(lLevel==rLevel){
    		return (1<<lLevel)-1;
    	}else{
    		return countNodes(root.left)+countNodes(root.right)+1;
    	}
    }
}
