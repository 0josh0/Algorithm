package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 题意：把二叉树横向连接起来
 * 分析：层次遍历
 */
public class PopulatingNextRightPointersEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null) return ;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	TreeLinkNode cur = queue.peek();
        	for(int i=0;i<size;i++){
        		cur = queue.poll();
        		if(!queue.isEmpty()&&i<size-1){
        			cur.next=queue.peek();
        		}
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        	cur.next=null;
        }
    }
}
