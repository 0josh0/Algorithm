package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：将二叉树变换成前序链表，只有右子树，没有左子树。空间复杂度O(1)
 * 分析：递归+深搜
 * 	         把root的左子树挂在root的右侧，把原来root的右子树挂在左子树的最右侧，
 * 	         递归root.right继续执行第一步
 */
public class FlattenBinaryTreetoLinkedList {
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
		
		flatten(n1);
		while(n1!=null){
			System.out.println(n1.val);
			n1=n1.right;
		}
	}
	public void flatten(TreeNode root) {
		if(root==null){
			return ;
		}
		if(root.left!=null){//将左子树的根节点放到root的right上，原来的right节点放到左子树的最右侧
			TreeNode rightNode = root.right;
			root.right=root.left;
			root.left = null;
			TreeNode head = root.right;
			while(head.right!=null){//找到root原左子树最右侧
				head=head.right;
			}
			head.right=rightNode;
		}
		flatten(root.right);//递归
    }
	
}
