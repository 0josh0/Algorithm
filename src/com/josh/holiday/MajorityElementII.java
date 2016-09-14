package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺��һ�������г��ִ�������n/3�ε�Ԫ�أ�Ҫ��ռ临�Ӷ�O(1),ʱ�临�Ӷ�O(n)
 * ������Ħ��ͶƱ�������α�������һ���ҵ�2���������ڶ���ͳ���������������ֵĴ������ж��Ƿ���������
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
        int n1=nums[0],n2=nums[1],c1=1,c2=1,index=2;//��ʼ��������ѡn1��n2
        if(n1==n2){//���³�ʼ��n2
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
        	return res;//����Ԫ�ض���ȣ�����n1
        }
        //n1��n2��ʼ����ϣ���������Ѱ������
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
        //��ʱ�Ѿ��ҵ���������n1��n2,�ٱ���һ�����飬ͳ��n1��n2���ֵĴ����Ƿ�����Ҫ��
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
