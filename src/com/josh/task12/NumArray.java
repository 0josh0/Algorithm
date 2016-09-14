package com.josh.task12;

/*
 * ���⣺����һ����������nums�������±�i��j֮���Ԫ�غͣ�i �� j���������߽硣
 *     ����update(i, val)��λ���±�i��Ԫ��ֵ�޸�Ϊval��
 * ������1������ⷨ����ʱ
 * 	   2��segment tree�߶���(������)
 * 	   3����״����
 */
public class NumArray {
	
	class SegmentTree{//�����߶���
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
	//��ʼ���߶���
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
	//�����߶�����ĳ���ڵ�ֵ
	private int update(SegmentTree root,int i,int val){
		if(root.low==root.hight&&i==root.low){
			int old = root.val;
			root.val = val;
			return old;//Ҫ��¼��ԭ���ڵ��ֵ�������������Ƚڵ��ֵ
		}
		int mid = (root.low+root.hight)/2;
		int old = 0;
		if(i>=root.low&&i<=mid){//Ҫ���µĽڵ���������
			old = update(root.left,i,val);
		}else{
			old = update(root.right,i,val);
		}
		root.val = root.val-old+val;//�������Ƚڵ�ֵ
		return old;
	}
	//���������
	private int sumRange(SegmentTree root,int i,int j){
		if(root.low==i&&root.hight==j)
			return root.val;//��ǰ����ǡ������������
		int mid = (root.low+root.hight)/2;
		if(i<=mid&&mid>=j){//���������ڵ�ǰ��������
			return sumRange(root.left,i,j);
		}else if(mid<i&&mid<j){//���������ڵ�ǰ������Ҳ�
			return sumRange(root.right,i,j);
		}else{
			return sumRange(root.left,i,mid)+sumRange(root.right,i=mid+1,j);
		}
	}

	private SegmentTree root = null;
	private int size = 0;
	//���캯��
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
