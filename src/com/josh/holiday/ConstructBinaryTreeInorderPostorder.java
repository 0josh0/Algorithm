package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：根据后序遍历和中序遍历构造二叉树
 * 分析：根据后序遍历最后一个元素确定当前根节点，在中序遍历中找到根节点位置，确定当前根节点的左右子树的节点
 *      然后对当前左右子树递归执行
 */
public class ConstructBinaryTreeInorderPostorder {
	@Test
	public void test(){
		int[] inorder={4,2,5,1,3};
		int[] postorder={4,5,2,3,1};
		helper(inorder,0,4,postorder,0,4);
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0) return null;
		return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
	public TreeNode helper(int[] inorder,int iLeft,int iRight,int[] postorder,int pLeft,int pRight){
		if(iRight<iLeft){//当前中序和后序中没有元素，说明到达叶子节点的子节点，返回null
			return null;
		}else{
			TreeNode root = new TreeNode(postorder[pRight]);//构造当前节点
			int rootPos = findRootPos(inorder,iLeft,iRight,root.val);//寻找当前节点在中序遍历中的位置，
			//int leftLen=rootPos-iLeft;//左子树包含的元素个数
			int rightLen = iRight-rootPos;//右子树包含的元素个数。确定左子树和右子树范围
			root.left = helper(inorder,iLeft,rootPos-1,postorder,pLeft,pRight-rightLen-1);//递归构造左子树和右子树
			root.right = helper(inorder,rootPos+1,iRight,postorder,pRight-rightLen,pRight-1);
			return root;
		}
	}
	public int findRootPos(int[] inorder,int left,int right,int val){
		for(int i=left;i<=right;i++){
			if(inorder[i]==val) return i;
		}
		return 0;
	}
}
