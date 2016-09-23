package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：寻找二叉树两个节点的最近祖先
 * 分析：1、递归 
 * 	    一共有以下几种情况：
 *   1）根节点即为p或者q，直接return root
 *   2）q和p分别在root的左子树和右子树，直接return root
 *   3）都在左侧或者都在右侧：递归
 * 
 */
public class LCAofBT {
	@Test
	public void test(){
		TreeNode n1=new TreeNode(6);
    	TreeNode n2=new TreeNode(2);
    	TreeNode n3=new TreeNode(8);
    	TreeNode n4=new TreeNode(0);
    	TreeNode n5=new TreeNode(4);
    	TreeNode n6=new TreeNode(7);
    	TreeNode n7=new TreeNode(9);
    	TreeNode n8=new TreeNode(3);
    	TreeNode n9=new TreeNode(5);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=n5;
    	
    	n3.left=n6;
    	n3.right=n7;
    	
    	n5.left=n8;
    	n5.right=n9;
    	//hasNode(n1,n8);
    	System.out.println(hasNode(n1,n8));
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||root==p||root==q) return root;//其中一个是根节点
		else{
			//判断左子树中是否存在p或q
			TreeNode left =  lowestCommonAncestor(root.left, p, q);
			//判断右子树中是否存在p或q
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if(left!=null&&right!=null) return root;//左子树和右子树中各有一个
			else{//如果左子树为null，说明都在右侧，否则在左侧
				return left==null?right:left;
			}
		}
    }
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root==p||root==q) return root;//其中一个是根节点
		else if(hasNode(root.left,p)&&hasNode(root.left,q)){//两个节点都在root的左子树中
			return lowestCommonAncestor(root.left, p, q);
		}else if(hasNode(root.right,p)&&hasNode(root.right,q)){//两个节点都在root的右子树中
			return lowestCommonAncestor(root.right,p,q);
		}else{//左子树和右子树各一个
			return root;
		}
    }
	public boolean hasNode(TreeNode root,TreeNode node){
		if(root==null){
			return false;
		}else{
			if(root==node) return true;
			boolean left = hasNode(root.left,node);
			boolean right = hasNode(root.right,node);
			return (left||right);
		}
	}
}
