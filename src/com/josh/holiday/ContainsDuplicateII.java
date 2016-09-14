package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * ����: Ѱ���������Ƿ���Ψһһ���ظ������֣������������ֵ��±�֮��ܳ���k
 * ����: ��hashMap�洢ÿ�����ֺ��±꣬���ظ�����ʱ������һ�����������ж�k�ı�ʶ�������count��lessK�ж��Ƿ�����k��Ψһ����������
 */
public class ContainsDuplicateII {
	@Test
	public void test(){
		int[] nums={1,0,1};
		System.out.println(containsNearbyDuplicate(nums, 1));
	}
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	int count = 0;
    	boolean lessK = false;
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			int index = map.get(nums[i]);
    			if(i-index<=k){
    				lessK = true;
    				count++;
    			}
    		}
    		map.put(nums[i], i);
    	}
    	if(count==1 && lessK==true) return true;
    	return false;  
    }
}
