package com.josh.holiday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：层次遍历二叉树，按层输出
 * 分析：
 */
public class BinaryTreeLevelTraversal {

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
	
	levelOrder(n1);
}
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(root==null) return list;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		List<Integer> cList = new ArrayList<Integer>();
    		for(int i=0;i<size;i++){
    			TreeNode curNode = queue.poll();
    			if(curNode.left!=null) queue.add(curNode.left);
    			if(curNode.right!=null) queue.add(curNode.right);
    			cList.add(curNode.val);
    			//System.out.print(curNode.val+"  ");
    		}
    		list.add(cList);
    		//System.out.println();
    	}
		return list;
    }
}
