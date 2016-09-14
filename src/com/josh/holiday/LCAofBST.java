package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ҵ���������Ĺ�ͬ�������
 * �������ݹ�.�����ж�p��q�ڵ�ֵ�ô�С��Ȼ���ж�����root����໹���Ҳࡣ
 *     ����������ֱ�ӷ���root��������һ�࣬�ݹ����.
 */
public class LCAofBST {
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
    	
    	TreeNode n = lowestCommonAncestor(n1,n6,n8);
    	System.out.println(n.val);
	}
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){//pΪ�ҽڵ�,qΪ��ڵ�
        	if(p.val<root.val){//p��q����root�����
        		return lowestCommonAncestor(root.left,p,q);
            }else if(q.val>root.val){//p��q����root���Ҳ�
            	return lowestCommonAncestor(root.right,p,q);
            }else{//q��p��root����
            	return root;
            }
        }else{
        	if(q.val<root.val){
        		return lowestCommonAncestor(root.left,p,q);
            }else if(p.val>root.val){
            	return lowestCommonAncestor(root.right,p,q);
            }else{
            	return root;
            }
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftNode = p,rightNode = q;
    	if(p.val>q.val){
    		leftNode = q;
    		rightNode = p;
    	}
        if(rightNode.val<root.val){
    		return lowestCommonAncestor(root.left,p,q);
        }else if(leftNode.val>root.val){
        	return lowestCommonAncestor(root.right,p,q);
        }else{
        	return root;
        }
    }
}
