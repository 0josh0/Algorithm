package com.josh.task12;

/*
 * 题意：给定一个整数数组nums，计算下标i与j之间的元素和（i ≤ j），包含边界。
 *     函数update(i, val)将位于下标i的元素值修改为val。
 * 分析：1、常规解法，超时
 * 	   2、segment tree线段树(区间树)
 * 	   3、树状数组
 */
public class NumArray {
	
	class SegmentTree{//定义线段树
		int low=0;
		int hight=0;
		int val=0;
		SegmentTree left = null;
		SegmentTree right = null;
		SegmentTree(int l,int h,int v){
			low = l;
			hight = h;
			val = v;
 		}
	}
	//初始化线段树
	private SegmentTree buildSegmentTree(int[]nums,int low,int hight){
		if(low>hight) return null;
		if(low==hight){
			SegmentTree root = new SegmentTree(low,hight,nums[low]);
			return root;
		}
		
		SegmentTree root = new SegmentTree(low,hight,0);
		int mid=(low+hight)/2;
		root.left = buildSegmentTree(nums,low,mid);
		root.right = buildSegmentTree(nums,mid+1,hight);
		root.val = root.left.val+root.right.val;
		return root;
	}
	//更新线段树的某个节点值
	private int update(SegmentTree root,int i,int val){
		if(root.low==root.hight&&i==root.low){
			int old = root.val;
			root.val = val;
			return old;//要记录下原来节点的值，用来更新祖先节点的值
		}
		int mid = (root.low+root.hight)/2;
		int old = 0;
		if(i>=root.low&&i<=mid){//要更新的节点在左子树
			old = update(root.left,i,val);
		}else{
			old = update(root.right,i,val);
		}
		root.val = root.val-old+val;//更新祖先节点值
		return old;
	}
	//搜索区间和
	private int sumRange(SegmentTree root,int i,int j){
		if(root.low==i&&root.hight==j)
			return root.val;//当前区间恰好是所求区间
		int mid = (root.low+root.hight)/2;
		if(i<=mid&&mid>=j){//所求区间在当前区间的左侧
			return sumRange(root.left,i,j);
		}else if(mid<i&&mid<j){//所求区间在当前区间的右侧
			return sumRange(root.right,i,j);
		}else{
			return sumRange(root.left,i,mid)+sumRange(root.right,i=mid+1,j);
		}
	}

	private SegmentTree root = null;
	private int size = 0;
	//构造函数
    public NumArray(int[] nums) {
    	root = buildSegmentTree(nums,0,nums.length-1);
    	size = nums.length;
    }
    
    public void update(int i, int val) {
    	if(i<0||i>=size) return;
        update(root,i,val);
    }

    public int sumRange(int i, int j) {
    	if(i<0||i>=size||i>j) return -1;
        return sumRange(root,i,j);
    }
}
