package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * ���⣺��������������֮�͵���target���������
 * ������1���̶�һ������Ȼ�������ĺ�һ��Ϊһ��ָ�룬�������Ϊһ��ָ�룬ͨ���ƶ�����ָ����ȷ��������֮��
 *        -- û�뵽������Ȼ��ʱ�ˣ���ʱ�临�Ӷ�O(n2) �ռ临�Ӷ�O(n)
 *      2����twoSum�����ϣ���threeSum��������������
 *      �������飬�Ե�ǰnums[i],��0��i-1��Χ�ڣ���twoSum(target-nums[i])
 * 
 * 
 */
public class TreeSum {
	@Test
	public void tes(){
		//int[] nums={-2,0,1,1,2};
		int[] nums={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = threeSum(nums);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<3) return res;
		Arrays.sort(nums);
		for(int i=nums.length-1;i>=2;i--){
			if(i<nums.length-1&&nums[i]==nums[i+1]) continue;//ȥ��
			List<List<Integer>> twoRes = twoSum(nums,i-1,0-nums[i]);
			for(int j=0;j<twoRes.size();j++){
				twoRes.get(j).add(nums[i]);
			}
			res.addAll(twoRes);
		}
		return res;
	}
	public List<List<Integer>> twoSum(int[] nums,int right,int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<2) return res;
		int start=0,end=right;
		while(start<end){
			if(nums[start]+nums[end]==target){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[start]);
				list.add(nums[end]);
				res.add(list);
				start++;
				end--;
				while(start<end&&nums[start]==nums[start-1]) start++;
				while(start<end&&nums[end]==nums[end+1]) end--;//ȥ��
			}else if(nums[start]+nums[end]>target){
				end--;
			}else{
				start++;
			}
		}
		return res;
	}
	
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3) return res;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
        	int left=i+1,right=nums.length-1,sum = 0;
        	while(left<right){
        		sum = nums[i]+nums[left]+nums[right];
        		if(sum==0){
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(nums[i]);
        			list.add(nums[left]);
        			list.add(nums[right]);
        			left++;
        			set.add(list);
        		}else if(sum>0){
        			right--;
        		}else{
        			left++;
        		}
        	}
        }
        res.addAll(set);
    	return res;
    }
}
