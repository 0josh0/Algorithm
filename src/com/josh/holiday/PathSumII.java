package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺��������дӸ��ڵ㵽Ҷ�ӽڵ�͵���sum������·��
 * ���������������������ÿһ��·���ĺͣ����������list
 * 	         �����������1��ͷָ��Ϊ�ո�  return 
 *              2��Ҷ�ӽڵ� - return��һ������sum+val
 *              3��һ��ڵ� - return left / right
 * 
 */
public class PathSumII {
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
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//res = pathSum(n1,11);
		DFS(n1,0);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.println(res.get(i).get(j));
			}
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       List<Integer> list = new ArrayList<Integer>();
       if(root==null) return res;
       list.add(root.val);
       helper(root,sum-root.val,res,list);
	   return res;
    }
	public void helper(TreeNode root,int sum,List<List<Integer>> res,List<Integer> list){
		if(root==null) return ;
		if(root.left==null&&root.right==null&&sum==0){//����Ҷ�ӽڵ㣬��������·��֮�͵���sum����������res
			res.add(new ArrayList<Integer>(list));
			//res.add(list);
			return;
		}
		if(root.left!=null){//��߲�����null���ݹ�ִ��
			list.add(root.left.val);
			helper(root.left,sum-root.left.val,res,list);
			list.remove(list.size()-1);//ɾ�����һ��Ԫ��
		}
		if(root.right!=null){
			list.add(root.right.val);
			helper(root.right,sum-root.right.val,res,list);
			list.remove(list.size()-1);
		}
	}
	public void DFS(TreeNode root,int sum){//sum�ǵ�ǰroot�ڵ�֮ǰ���нڵ�ĺ�
		if(root==null) return ;//���1
		else if(root.left==null&&root.right==null){//���2
			sum = sum+root.val;
			System.out.println(sum);
		}else{//���3
			DFS(root.left,sum+root.val);
			DFS(root.right,sum+root.val);
		}
	}
}
