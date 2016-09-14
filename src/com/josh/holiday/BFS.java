package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 二叉树深度优先搜索
 */
public class BFS {
	@Test
	public void test(){
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(8);
	
	n1.left=n2;
	n1.right=n3;
	n2.left=n4;
	n2.right=n5;
	n3.left=n6;
	n3.right=n7;
	n5.left = n8;
	
	List<TreeNode> res = new ArrayList<TreeNode>();
	BFSSearch(n1, res,0);
	for(int i=0;i<res.size();i++){
		System.out.println(res.get(i).val);
	}

}
	int maxLevel=-1;
	public void BFSSearch(TreeNode root,List<TreeNode> res,int curLevel){
		if(root==null)return;
		else{
			if(curLevel>maxLevel){
				maxLevel = curLevel;
				res.add(root);
			}
			if(root.right!=null) BFSSearch(root.right, res,curLevel+1);
			if(root.left!=null) BFSSearch(root.left, res,curLevel+1);
			//if(root.right!=null) BFSSearch(root.right, res);
		}
	}
}
