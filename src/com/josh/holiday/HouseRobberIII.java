package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：对一颗二叉树，不能连续累加父子节点的值，只能隔代相加，求最大值
 * 分析：层次遍历-错误！
 */
public class HouseRobberIII {
	@Test
	public void test(){
		TreeNode n1=new TreeNode(4);
    	TreeNode n2=new TreeNode(1);
    	TreeNode n3=new TreeNode(2);
    	TreeNode n4=new TreeNode(3);
    	
    	n1.left=n2;
    	//n1.right=n3;
    	
    	//n2.left=n4;
    	n2.right=n3;
    
    	//n3.left = n6;
   	    n3.right=n4;
   	    
   	 System.out.println(rob(n1));
	}
	public int rob(TreeNode root) {
		return helper(root)[0];
	}
	public int[] helper(TreeNode root){
		/*
		 * 用一个dp数组记录每次递归结果
		 * dp[0]:记录当前节点.val+当前节点孙子节点最大值和当前节点的儿子节点(left、right)最大值，两者中的最大值
		 * 		 dp[0] = Max(root.val+Max(root.everygrandson),Max(root.left)+Max(root.right))
		 * dp[1]:记录当前节点的儿子节点的最大值之和
		 * 		 dp[1] = Max(root.left)+Max(root.right)
		 */
		int[] dp={0,0};
		if(root!=null){
			int[] dpL = helper(root.left);
			int[] dpR = helper(root.right);
			dp[1] = dpL[0]+dpR[0];
			dp[0] = Math.max(dp[1], dpL[1]+dpR[1]+root.val);
		}
		return dp;
	}
	public int rob1(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level=0,odd=0,even=0,three=0;
		while(!queue.isEmpty()){
			int size = queue.size();
			level++;
			//System.out.print("第"+level+"层： ");
			for(int i=0;i<size;i++){
				TreeNode curNode = queue.poll();
				if(level%2==0) even+=curNode.val;
				if(level%2==1) odd+=curNode.val;
				if(level%3==1) three+=curNode.val;
				//System.out.print(curNode.val+"  ");
				if(curNode.left!=null) queue.add(curNode.left);
				if(curNode.right!=null) queue.add(curNode.right);
			}
			//System.out.println();
		}
		return Math.max(three, Math.max(odd, even));
    }
}
