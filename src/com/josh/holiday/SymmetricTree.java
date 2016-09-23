package com.josh.holiday;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * ���⣺�ж�һ���������Ƿ�����Լ�����. ���� 1(2,2)(3,4,4,3)
 * ������1��������ȱ�����ֻ������ȫΪnullֹͣ��ӣ�����һ��Ϊnull����0���롣Ȼ����������һ�Σ����Ҳ�����һ�Σ����ν��һ����Գơ�
 *     2���ݹ� 1 ��ǰ�ڵ�==null return true; 
 *           2 ��ǰ�ڵ�!=null 1) ������Ϊnull����������Ϊnull return left==right
 *           				2) �ݹ��������������������������������Ƚϣ��������������������������������Ƚ�
 */
public class SymmetricTree {

	//�ݹ�ʵ��
	public boolean isSymmetric2(TreeNode root){
		if(root==null) return true;
		return compare(root.left,root.right);
	}
	public boolean compare(TreeNode left,TreeNode right){
		if(left==null || right==null) return left==right;
		if(left.val!=right.val){
			return false;
		}else{
			return compare(left.left,right.right) && compare(left.right,right.left);
		}
	}
	public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		ArrayList<Integer> left=new ArrayList<>();
		ArrayList<Integer> right=new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			left.add(curNode.val);
			if(curNode.left!=null || curNode.right!=null){
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
			}
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			right.add(curNode.val);
			if(curNode.left!=null || curNode.right!=null){
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
			}
		}
		for(int i=0;i<left.size();i++){
			if(left.get(i)!=right.get(i)) return false;
		}
		return true;
	}
	//����������ȱ���
	public void DFS(TreeNode root){
		if(root==null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			System.out.println(curNode.val);

			if(curNode.left!=null || curNode.right!=null){
				if(curNode.left!=null){
					stack.push(curNode.left);
				}else{
					stack.push(new TreeNode(0));
				}
				if(curNode.right!=null){
					stack.push(curNode.right);
				}else{
					stack.push(new TreeNode(0));
				}
			}
			//if(curNode.right!=null) stack.push(curNode.right);
			//if(curNode.left!=null) stack.push(curNode.left);
		}
	}
	@Test
	public void test(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
		//DFS(n1);
		System.out.println(isSymmetric2(n1));
	}
}
