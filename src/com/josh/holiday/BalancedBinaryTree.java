package com.josh.holiday;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：判断一个二叉树是否是平衡二叉树。平衡二叉树-左子树和右子树深度之差不超过1
 * 分析：递归。层次遍历，计算每层节点数，1-2-4-8-……倒数第二层节点数是2的幂数，是平衡二叉树，否则不是。
 *      <计算深度，输出每层节点>
 *      输出每层节点：利用queue.size()
 */
public class BalancedBinaryTree {
	//递归求左右子树的高度-差
	public boolean isBalanced(TreeNode root) {//每一个节点的左右子树高度差不超过1
		if(root==null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode curNode = root;
		queue.add(root);
		while(!queue.isEmpty()){
			curNode = queue.poll();
			int leftDepath=0,rightDepath=0;
			if(curNode.left!=null){
				leftDepath=depath(curNode.left,1);
				queue.add(curNode.left);
			}
			if(curNode.right!=null){
				rightDepath=depath(curNode.right,1);
				queue.add(curNode.right);
			}
			if(Math.abs(leftDepath-rightDepath)>1) return false;
		}
		return true;
	}
	public int depath(TreeNode root,int depath){
		int leftDepath=depath,rightDepath=depath;
		if(root.left!=null) leftDepath = depath(root.left,depath+1);
		if(root.right!=null) rightDepath = depath(root.right,depath+1);
		if(Math.abs(leftDepath-rightDepath)>1) return -1;
		return Math.max(leftDepath, rightDepath);
	}
	public int depath1(TreeNode root,int depath){
		if(root==null) return depath;
		int leftDepath = depath1(root.left,depath+1);
		int rightDepath = depath1(root.right,depath+1);
		if(Math.abs(leftDepath-rightDepath)>1) return -1;
		return Math.max(leftDepath, rightDepath);
	}
	public boolean isBalanced1(TreeNode root) {
		return depath1(root,1)>=0;
	}
	public boolean isBalanced2(TreeNode root) {//判断平衡二叉树
		if(root==null||(root.left==null&&root.right==null)) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashMap<Integer,Integer> map = new HashMap<>();
		queue.add(root);
		int levelNum = 0,level=0;
		while(!queue.isEmpty()){
			level++;
			levelNum = queue.size();
			map.put(level, levelNum);
		    //System.out.println(levelNum);
			for(int i=0;i<levelNum;i++){
				if(queue.peek().left!=null) queue.add(queue.peek().left);
				if(queue.peek().right!=null) queue.add(queue.peek().right);
				//System.out.print(queue.peek().val+"  ");
				queue.poll();
			}
		}
        return Math.pow(2,map.size()-2)==map.get(map.size()-1);
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
    	TreeNode n8=new TreeNode(8);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=n5;
    	
//    	n3.left=n6;
   	    n3.right=n6;
    	
   	    n4.left = n7;
   	    
   	    n6.right = n8;
    	//isBalanced(n1);
    	System.out.println(isBalanced1(n1));
    	//System.out.println(depath(n1,1));
    	//depthSearch(n1);
    }
}
