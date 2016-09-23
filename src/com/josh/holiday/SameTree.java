package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意：判断两个二叉树是否相同
 * 分析：结构相同，对应节点的值相同，深度优先遍历二叉树，比较
 */
public class SameTree {
	//树的问题，遍历，递归
	public boolean isSameTree2(TreeNode p,TreeNode q){
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		if(p.val == q.val){
			return (isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right));
		}
		return false;
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null) return true;
    	if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val) return false;
    	Stack<TreeNode> stackP = new Stack<>();
    	Stack<TreeNode> stackQ = new Stack<>();
    	TreeNode curP = null,curQ=null;
    	stackP.push(p);
    	stackQ.push(q);
    	while(!stackP.isEmpty() && !stackQ.isEmpty()){
    		curP=stackP.pop();
    		curQ=stackQ.pop();
    		if(curP.val != curQ.val) return false;//比较当前节点值
    		if((curP.left==null && curQ.left!=null) || (curP.left!=null && curQ.left==null)) return false;
    		if((curP.right==null && curQ.right!=null) || (curP.right!=null && curQ.right==null)) return false;//比较左右树结构
    		if(curP.right!=null){
    			stackP.push(curP.right);
    			stackQ.push(curQ.right);
    		}
    		if(curP.left!=null){
    			stackP.push(curP.left);
    			stackQ.push(curQ.left);
    		}
    	}
        return true;
    }
	
    @Test
    public void test(){
    	TreeNode n1=new TreeNode(1);
    	TreeNode n2=new TreeNode(2);
    	TreeNode n3=new TreeNode(3);
    	TreeNode n4=new TreeNode(4);
    	TreeNode n5=new TreeNode(5);
    	TreeNode n6=new TreeNode(6);
    	TreeNode n7=new TreeNode(7);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=null;
    	
    	n3.left=n5;
    	n3.right=n6;
    	
    	n4.left=null;
    	n4.right=null;
    	
    	n5.left=n7;
    	n5.right=null;
    	
    	n6.left=null;
    	n6.right=null;
    	
    	n7.left=null;
    	n7.right=null;
    	
    	TreeNode n = new TreeNode(1);
    	TreeNode m = new TreeNode(1);
    	n.left =null;
    	n.right=m;
    	
    	TreeNode nn = new TreeNode(1);
    	TreeNode m1 = new TreeNode(1);
    	nn.left =null;
    	nn.right=m1;
    	
    	System.out.println(isSameTree2(n, nn));
    	//System.out.println(!(m==null && t1 ==null));
    }
}
