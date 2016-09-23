package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * ����: ������ǰ�������ǰ�򣺸�-��-��
 * 					������-��-��
 * 					������-��-��
 * ����: ǰ�������ջ���ҽڵ�����ջ����ڵ����ջ
 */

public class BinaryTreePreorderTraversal {
	@Test
	public void test(){
		TreeNode n1=new TreeNode(1);
//    	TreeNode n2=new TreeNode(2);
//    	TreeNode n3=new TreeNode(3);
//    	TreeNode n4=new TreeNode(4);
//    	TreeNode n5=new TreeNode(5);
//    	TreeNode n6=new TreeNode(6);
//    	TreeNode n7=new TreeNode(7);
//    	TreeNode n8=new TreeNode(8);
    	
//    	n1.left=n2;
//    	n1.right=n3;
//    	
//    	n2.left=n4;
//    	n2.right=n5;
//    	
////    	n3.left=n6;
//   	    n3.right=n6;
//    	
//   	    n4.left = n7;
//   	    
//   	    n6.right = n8;
    	preorderTraversal(n1);
	}
	//�ǵݹ�ʵ��
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode curNode = stack.pop();
        	list.add(curNode.val);
        	if(curNode.right!=null) stack.push(curNode.right);
        	if(curNode.left!=null) stack.push(curNode.left);
        }
        return list;
    }
	//�ݹ�ʵ��
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
		pre(root,list);
		return list;
	}
	public void pre(TreeNode root,List<Integer> list){
		if(root!=null){
			list.add(root.val);
			pre(root.left,list);
			pre(root.right,list);
		}
	}
}
