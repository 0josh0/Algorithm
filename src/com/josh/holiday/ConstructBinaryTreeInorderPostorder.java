package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺���ݺ������������������������
 * ���������ݺ���������һ��Ԫ��ȷ����ǰ���ڵ㣬������������ҵ����ڵ�λ�ã�ȷ����ǰ���ڵ�����������Ľڵ�
 *      Ȼ��Ե�ǰ���������ݹ�ִ��
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
		if(iRight<iLeft){//��ǰ����ͺ�����û��Ԫ�أ�˵������Ҷ�ӽڵ���ӽڵ㣬����null
			return null;
		}else{
			TreeNode root = new TreeNode(postorder[pRight]);//���쵱ǰ�ڵ�
			int rootPos = findRootPos(inorder,iLeft,iRight,root.val);//Ѱ�ҵ�ǰ�ڵ�����������е�λ�ã�
			//int leftLen=rootPos-iLeft;//������������Ԫ�ظ���
			int rightLen = iRight-rootPos;//������������Ԫ�ظ�����ȷ������������������Χ
			root.left = helper(inorder,iLeft,rootPos-1,postorder,pLeft,pRight-rightLen-1);//�ݹ鹹����������������
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
