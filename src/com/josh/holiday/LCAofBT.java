package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺Ѱ�Ҷ����������ڵ���������
 * ������1���ݹ� 
 * 	    һ�������¼��������
 *   1�����ڵ㼴Ϊp����q��ֱ��return root
 *   2��q��p�ֱ���root������������������ֱ��return root
 *   3�����������߶����Ҳࣺ�ݹ�
 * 
 */
public class LCAofBT {
	@Test
	public void test(){
		TreeNode n1=new TreeNode(6);
    	TreeNode n2=new TreeNode(2);
    	TreeNode n3=new TreeNode(8);
    	TreeNode n4=new TreeNode(0);
    	TreeNode n5=new TreeNode(4);
    	TreeNode n6=new TreeNode(7);
    	TreeNode n7=new TreeNode(9);
    	TreeNode n8=new TreeNode(3);
    	TreeNode n9=new TreeNode(5);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=n5;
    	
    	n3.left=n6;
    	n3.right=n7;
    	
    	n5.left=n8;
    	n5.right=n9;
    	//hasNode(n1,n8);
    	System.out.println(hasNode(n1,n8));
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||root==p||root==q) return root;//����һ���Ǹ��ڵ�
		else{
			//�ж����������Ƿ����p��q
			TreeNode left =  lowestCommonAncestor(root.left, p, q);
			//�ж����������Ƿ����p��q
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if(left!=null&&right!=null) return root;//���������������и���һ��
			else{//���������Ϊnull��˵�������Ҳ࣬���������
				return left==null?right:left;
			}
		}
    }
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root==p||root==q) return root;//����һ���Ǹ��ڵ�
		else if(hasNode(root.left,p)&&hasNode(root.left,q)){//�����ڵ㶼��root����������
			return lowestCommonAncestor(root.left, p, q);
		}else if(hasNode(root.right,p)&&hasNode(root.right,q)){//�����ڵ㶼��root����������
			return lowestCommonAncestor(root.right,p,q);
		}else{//����������������һ��
			return root;
		}
    }
	public boolean hasNode(TreeNode root,TreeNode node){
		if(root==null){
			return false;
		}else{
			if(root==node) return true;
			boolean left = hasNode(root.left,node);
			boolean right = hasNode(root.right,node);
			return (left||right);
		}
	}
}
