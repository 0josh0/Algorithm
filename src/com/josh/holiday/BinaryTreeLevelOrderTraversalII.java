package com.josh.holiday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/*
 * 题意：从底向上的层次遍历，一次输出每层节点
 * 分析：用栈，先入后出，。。。。。。。。
 */
public class BinaryTreeLevelOrderTraversalII {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null) return null;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> cList = new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				TreeNode curNode = queue.poll();
				cList.add(curNode.val);
				if(curNode.left!=null) queue.add(curNode.left);
				if(curNode.right!=null) queue.add(curNode.right);
			}
			stack.push(cList);
		}
		while(!stack.isEmpty()){
//			List<Integer> cList = new ArrayList<Integer>();
//			cList = stack.pop();
			list.add(stack.pop());
//			for(int j=0;j<cList.size();j++){
//				System.out.println(cList.get(j));
//				//list.add(e)
//			}
		}
		return list;
		
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
		
		levelOrderBottom(n1);
	}
}
