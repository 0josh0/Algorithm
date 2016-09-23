package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意: 给定一个sum，求从二叉树的root到各个叶子节点所有值相加是否有等于的sum
 * 分析: 1 深度遍历
 * 		2  递归求和
 */
public class PathSum {
	@Test
	public void test(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		System.out.print(hasPathSum2(n1,10));
	}
	public boolean hasPathSum2(TreeNode root,int sum){
		if(root==null) return false;
		if(root.left==null && root.right==null && sum-root.val==0) return true;
		return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
		
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> level = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			level.push(curNode);
			if(curNode.right!=null) stack.push(curNode.right);
			if(curNode.left!=null) stack.push(curNode.left);
			if(level.peek().left==null && level.peek().right==null){//已经累加到叶子节点,开始计算和
				int treeSum = 0;
				for(int i=0;i<level.size();i++){
					treeSum = treeSum + level.get(i).val;
				}
				//System.out.println(treeSum);
				if(treeSum==sum) return true;
				level.pop();
				while(!stack.isEmpty() && !(level.peek().left==stack.peek() || level.peek().right==stack.peek())){
					level.pop();
				}
			}
		}
		return false;
    }
}
