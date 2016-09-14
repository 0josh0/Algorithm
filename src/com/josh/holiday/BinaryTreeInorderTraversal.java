package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

/*
 * 题意: 二叉树中序遍历；前序：根-左-右
 * 					中序：左-根-右
 * 					后序：左-右-根
 * 分析: 中序遍历.递归实现
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		pre(root,list);
		return list;
	}
	public void pre(TreeNode root,List<Integer> list){
		if(root!=null){
			pre(root.left,list);
			list.add(root.val);
			pre(root.right,list);
		}
	}
}
