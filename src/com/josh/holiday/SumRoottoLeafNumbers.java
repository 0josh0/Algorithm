package com.josh.holiday;
import org.junit.Test;

/*
 * 题意:求二叉树的根节点到所有叶子节点连接起来构成的数字之和
 * 分析:深度优先遍历。答题思路就是：用一个变量保存和sum，访问到当前节点时，前一层sum*10+当前节点值
 * 	        具体细节分三种情况：1、空指针 - 即node为空的情况，return 0
 * 					  2、叶子节点  - return sum*10+val
 * 					  3、一般节点(有孩子节点) - 递归 return left+right
 */
public class SumRoottoLeafNumbers {
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
	
	//sumNumbers(n1);
	//StringBuilder num = new StringBuilder();
	//DFS(n1,num);
	System.out.println(sumNumbers(n1));


}
	public int sumNumbers(TreeNode root) {
        int sum=0;
		return DFS(root,sum);
    }
	public int DFS(TreeNode root,int sum){//sum是当前root节点之前所有节点的和
		if(root==null) return 0;//情况1
		else if(root.left==null&&root.right==null){//情况2
			System.out.println(sum*10+root.val);
			return sum = sum*10+root.val;
		}else{
			return DFS(root.left,sum*10+root.val)+DFS(root.right,sum*10+root.val);//情况3
		}
	}
}
