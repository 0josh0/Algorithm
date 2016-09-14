package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

/*
 * ����: ���������������ǰ�򣺸�-��-��
 * 					������-��-��
 * 					������-��-��
 * ����: �������.�ݹ�ʵ��
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		pre(root,list);
		return list;
	}
	public void pre(TreeNode root,List<Integer> list){
		if(root!=null){
			pre(root.left,list);
			list.add(root.val);
			pre(root.right,list);
		}
	}
}
