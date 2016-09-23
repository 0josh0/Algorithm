package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 有序数组转换为二叉查找树
 * 分析: 递归。首先找到每部递归的root节点
 */
public class ConvertSortedArraytoBinarySearchTree {
	@Test
	public void test(){
		int[] nums={1,2,3,4};
		sortedArrayToBST(nums);
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums,0,nums.length-1);
    }
	public TreeNode helper(int[] nums,int start,int end){
		if(start<=end){
			TreeNode root = new TreeNode(nums[(start+end)/2]);
			root.left=helper(nums,start,(start+end)/2-1);
			root.right=helper(nums,(start+end)/2+1,end);
			return root;
		}
		return null;
	}
}
