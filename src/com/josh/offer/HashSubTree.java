package com.josh.offer;
/*
 * 判断tree1是否有tree2的子结构
 * 解法：递归
 */
public class HashSubTree {

	public boolean hasTree(Tree r1,Tree r2){
		boolean result = false;
		if(r1.value==r2.value){
			result = doCompare(r1,r2);
		}
		if(!result)result = hasTree(r1.left,r2);
		if(!result)result = hasTree(r1.right,r2);
		return result;
	}
	public boolean doCompare(Tree t1,Tree t2){
		if(t2==null){
			return true;
		}
		if(t1==null){
			return false;
		}
		return doCompare(t1.left,t2.left)&&doCompare(t1.right,t2.right);
	}
}
