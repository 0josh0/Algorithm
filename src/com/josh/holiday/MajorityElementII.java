package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意：求一个数组中出现次数多于n/3次的元素，要求空间复杂度O(1),时间复杂度O(n)
 * 分析：摩尔投票法，两次遍历，第一次找到2个众数，第二次统计这两个众数出现的次数，判断是否满足条件
 * 
 */
public class MajorityElementII {
	@Test
	public void test(){
		int[] nums = {0,3,4,0};
		majorityElement(nums);
	}
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
        if(nums.length==0) return res;
        if(nums.length==1){
        	res.add(nums[0]);
        	return res;
        }
        int n1=nums[0],n2=nums[1],c1=1,c2=1,index=2;//初始化众数候选n1和n2
        if(n1==n2){//重新初始化n2
        	c1++;
        	for(int i=2;i<nums.length;i++){
            	if(nums[i]!=n1){
            		n2=nums[i];
            		index=i+1;
            		break;
            	}
            	c1++;
            }
        }
        if(n1==n2){
        	res.add(n1);
        	return res;//所有元素都相等，返回n1
        }
        //n1和n2初始化完毕，遍历数组寻找众数
        for(int i=index;i<nums.length;i++){
        	if(nums[i]==n1){
        		c1++;
        	}else if(nums[i]==n2){
        		c2++;
        	}else{
        		if(c1==0){
        			n1=nums[i];
        			c1=1;
        		}else if(c2==0){
        			n2=nums[i];
        			c2=1;
        		}else{
        			c1--;
        			c2--;
        		}
        	}
        }
        //此时已经找到两个众数n1和n2,再遍历一次数组，统计n1和n2出现的次数是否满足要求
        c1=0;c2=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==n1) c1++;
        	if(nums[i]==n2) c2++;
        }
        if(c1>nums.length/3) res.add(n1);
        if(c2>nums.length/3) res.add(n2);
    	return res;
    }
}
