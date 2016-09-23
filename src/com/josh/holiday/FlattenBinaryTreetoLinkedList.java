package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺���������任��ǰ������ֻ����������û�����������ռ临�Ӷ�O(1)
 * �������ݹ�+����
 * 	         ��root������������root���Ҳ࣬��ԭ��root�����������������������Ҳ࣬
 * 	         �ݹ�root.right����ִ�е�һ��
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
		if(root.left!=null){//���������ĸ��ڵ�ŵ�root��right�ϣ�ԭ����right�ڵ�ŵ������������Ҳ�
			TreeNode rightNode = root.right;
			root.right=root.left;
			root.left = null;
			TreeNode head = root.right;
			while(head.right!=null){//�ҵ�rootԭ���������Ҳ�
				head=head.right;
			}
			head.right=rightNode;
		}
		flatten(root.right);//�ݹ�
    }
	
}
