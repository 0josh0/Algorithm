package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意: 找出二叉查找树种第k小的元素
 * 分析: 中序遍历，输出有序数组
 */
public class KthSmallestElementinBST {
	@Test
	public void test(){
		TreeNode n1=new TreeNode(4);
    	TreeNode n2=new TreeNode(2);
    	TreeNode n3=new TreeNode(6);
    	TreeNode n4=new TreeNode(1);
    	TreeNode n5=new TreeNode(3);
    	TreeNode n6=new TreeNode(5);
    	TreeNode n7=new TreeNode(7);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=n5;
    
    	n3.left = n6;
   	    n3.right=n7;
   	    
   	 System.out.println(kthSmallest(n1,3));
	}
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		helper(root,list);
        return list.get(k-1);
    }
	public void helper(TreeNode root,List<Integer> list){
		if(root!=null){
			helper(root.left,list);
			list.add(root.val);
			//System.out.println(root.val);
			helper(root.right,list);
		}
	}
}
