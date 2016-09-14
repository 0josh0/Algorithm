package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺�ж�һ���������Ƿ��Ƕ������������left<root<right
 * �������走������һ����Сʱ�������ˣ����������������Ƿ����򲻾��������
 */
public class ValidateBinarySearchTree {
	@Test
	public void test(){
	TreeNode n1 = new TreeNode(4);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(6);
	TreeNode n4 = new TreeNode(1);
	TreeNode n5 = new TreeNode(3);
	TreeNode n6 = new TreeNode(5);
	TreeNode n7 = new TreeNode(7);
	//TreeNode n8 = new TreeNode(8);
	
	n1.left=n2;
	n1.right=n3;
	n2.left=n4;
	n2.right=n5;
	n3.left=n6;
	n3.right=n7;
	//n5.left = n8;
	System.out.println(isValidBST(n1));
	}
	public boolean isValidBST(TreeNode root) {
    	if(root==null||(root.left==null&&root.right==null)) return true;
    	List<Integer> list = new ArrayList<Integer>();
    	inorder(root,list);//list������������Ԫ��
    	for(int i=1;i<list.size();i++){
    		if(list.get(i)<=list.get(i-1)) return false;
    	}
    	return true;
    }
    public void inorder(TreeNode root,List<Integer> list) {
    	if(root!=null){
    		inorder(root.left,list);
    		//System.out.println(root.val);//visit root
    		list.add(root.val);
    		inorder(root.right,list);
    	}
    }
}
