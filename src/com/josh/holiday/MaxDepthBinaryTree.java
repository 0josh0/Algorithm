package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意：求一个二叉树的最大深度
 * 分析：深度优先搜索
 * 
 */
public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
    	if(root==null) return 0;
    	if(root.left==null && root.right==null) return 1;
    	//TreeNode curNode = root;
    	int leftDepath = 1;
    	int rightDepath = 1;
    	if(root.left!=null) leftDepath = maxDepth(root.left)+1;
        if(root.right!=null) rightDepath = maxDepth(root.right)+1;
    	return Math.max(leftDepath, rightDepath);
    }
    //二叉树深度优先搜索 Stack存储
    public void depthSearch(TreeNode root){
    	if(root==null) System.out.println("no node!");;
    	if(root.left==null && root.right==null) System.out.println(root.val);
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode curNode = null;
    	stack.push(root);
    	while(!stack.isEmpty()){
    		curNode = stack.pop();
    		System.out.println(curNode.val);
    		if(curNode.right!=null) stack.push(curNode.right);
    		if(curNode.left!=null) stack.push(curNode.left);
    	}
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
    	
    	System.out.println(maxDepth(n1));
    	//depthSearch(n1);
    }
}
