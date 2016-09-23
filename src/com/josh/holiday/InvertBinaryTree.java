package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意：旋转二叉树
 * 分析：递归，左子树变右子树，右子树变左子树
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return root;
        //交换root的左右子树
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        //递归左右子树
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
    	return root;
    }
    @Test
    public void test(){
    	TreeNode n1=new TreeNode(1);
    	TreeNode n2=new TreeNode(2);
    	TreeNode n3=new TreeNode(3);
    	TreeNode n4=new TreeNode(4);
    	TreeNode n5=new TreeNode(5);
    	TreeNode n6=new TreeNode(6);
    	TreeNode n7=new TreeNode(7);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=null;
    	
    	n3.left=n5;
    	n3.right=n6;
    	
    	n4.left=null;
    	n4.right=null;
    	
    	n5.left=n7;
    	n5.right=null;
    	
    	n6.left=null;
    	n6.right=null;
    	
    	n7.left=null;
    	n7.right=null;
    	
    	invertTree(n1);
    	//深度优先遍历二叉树
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode curNode = null;
    	stack.push(n1);
    	while(!stack.isEmpty()){
    		curNode = stack.pop();
    		System.out.println(curNode.val);
    		if(curNode.right!=null) stack.push(curNode.right);
    		if(curNode.left!=null) stack.push(curNode.left);
    	}
    }
}
