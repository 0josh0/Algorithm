package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���⣺����һ������������ĵ����������η�����һ����Сֵ
 * �������������������ջ��
 */
public class BSTIterator {

	Queue<Integer> queue = new LinkedList<Integer>();
	public BSTIterator(TreeNode root) {
        inoder(root);
    }

	private void inoder(TreeNode root){
		if(root!=null){
			inoder(root.left);
			queue.add(root.val);
			inoder(root.right);
		}
	}
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!queue.isEmpty())return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
}
