package com.josh.holiday;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * 题意：判断一个二叉树是否关于自己镜像. 例如 1(2,2)(3,4,4,3)
 * 分析：1、深度优先遍历，只有左右全为null停止添加，若有一个为null，用0补齐。然后从左侧深搜一次，从右侧深搜一次，两次结果一样则对称。
 *     2、递归 1 当前节点==null return true; 
 *           2 当前节点!=null 1) 左子树为null或者右子树为null return left==right
 *           				2) 递归左子树的左子树和右子树的右子树比较，左子树的右子树和右子树的左子树比较
 */
public class SymmetricTree {

	//递归实现
	public boolean isSymmetric2(TreeNode root){
		if(root==null) return true;
		return compare(root.left,root.right);
	}
	public boolean compare(TreeNode left,TreeNode right){
		if(left==null || right==null) return left==right;
		if(left.val!=right.val){
			return false;
		}else{
			return compare(left.left,right.right) && compare(left.right,right.left);
		}
	}
	public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		ArrayList<Integer> left=new ArrayList<>();
		ArrayList<Integer> right=new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			left.add(curNode.val);
			if(curNode.left!=null || curNode.right!=null){
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
			}
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			right.add(curNode.val);
			if(curNode.left!=null || curNode.right!=null){
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
			}
		}
		for(int i=0;i<left.size();i++){
			if(left.get(i)!=right.get(i)) return false;
		}
		return true;
	}
	//树的深度优先遍历
	public void DFS(TreeNode root){
		if(root==null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			System.out.println(curNode.val);

			if(curNode.left!=null || curNode.right!=null){
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
			}
			//if(curNode.right!=null) stack.push(curNode.right);
			//if(curNode.left!=null) stack.push(curNode.left);
		}
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
		n3.right=n7;
		
		//DFS(n1);
		System.out.println(isSymmetric2(n1));
	}
}
