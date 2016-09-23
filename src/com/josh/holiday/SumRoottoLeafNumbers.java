package com.josh.holiday;
import org.junit.Test;

/*
 * ����:��������ĸ��ڵ㵽����Ҷ�ӽڵ������������ɵ�����֮��
 * ����:������ȱ���������˼·���ǣ���һ�����������sum�����ʵ���ǰ�ڵ�ʱ��ǰһ��sum*10+��ǰ�ڵ�ֵ
 * 	        ����ϸ�ڷ����������1����ָ�� - ��nodeΪ�յ������return 0
 * 					  2��Ҷ�ӽڵ�  - return sum*10+val
 * 					  3��һ��ڵ�(�к��ӽڵ�) - �ݹ� return left+right
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
	public int DFS(TreeNode root,int sum){//sum�ǵ�ǰroot�ڵ�֮ǰ���нڵ�ĺ�
		if(root==null) return 0;//���1
		else if(root.left==null&&root.right==null){//���2
			System.out.println(sum*10+root.val);
			return sum = sum*10+root.val;
		}else{
			return DFS(root.left,sum*10+root.val)+DFS(root.right,sum*10+root.val);//���3
		}
	}
}
