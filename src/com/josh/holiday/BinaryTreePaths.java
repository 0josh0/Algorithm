package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意：求二叉树中根节点到所有叶子节点的路径
 * 分析：深搜
 */
public class BinaryTreePaths {
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
	
	List<String> res = new ArrayList<String>();
//	String sb = "";
//	DFS(n1,res,sb);
	res = binaryTreePaths(n1);
	for(int i=0;i<res.size();i++){
		System.out.println(res.get(i));
	}

}
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if(root==null) return res;
		String sb=root.val+"";
		if(root.left==null&&root.right==null){
			res.add(sb);
		}
		DFS(root.left,res,sb);
		DFS(root.right,res,sb);
		return res;
        
    }
	public void DFS(TreeNode root,List<String> list,String sb){
		if(root==null){
			//list.add(sb);
			return;
		}else if(root.left==null&&root.right==null){
			sb=sb+"->"+(root.val);
			list.add(sb);
			//System.out.print(sb+" ");
		}else{
			DFS(root.left,list,sb+"->"+(root.val));
			DFS(root.right,list,sb+"->"+(root.val));
		}
	}
}
