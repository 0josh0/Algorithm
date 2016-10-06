package com.josh.offer;

import org.junit.Test;

/*
 * 树的镜像结构，就是左右子树递归交换位置
 * 解法：递归
 * 
 */
public class MirrorTree {

	@Test
	public void test(){
		Tree root = new Tree(8);
		Tree t1 = new Tree(6);
		Tree t2 = new Tree(10);
		Tree t3 = new Tree(5);
		Tree t4 = new Tree(7);
		Tree t5 = new Tree(9);
		Tree t6 = new Tree(11);
		
		root.left=t1;
		root.right=t2;
		t1.left=t3;
		t1.right=t4;
		t2.left=t5;
		t2.right=t6;
		
		mTree(root);
		
		System.out.println("mmm");
	}
	public void mTree(Tree root){
		if(root==null) return;
		if(root.left==null&&root.right==null) return;
		//交换左右子树
		Tree tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if(root.left!=null)
			mTree(root.left);
		if(root.right!=null)
			mTree(root.right);
	}
}
