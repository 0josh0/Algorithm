package com.josh.holiday;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * ���⣺�ж��������Ƿ����| nums[i] - nums[j] | <= t ���� | i - j | <= k
 * ����1��ȷ��һ��k���ȵĴ��ڣ��󴰿����Ƿ��������������ʱ�临�Ӷ�O��n*K��
 *      ---------------------����ĥ�ᳬʱ����Ȼ�ɣ���ʱ�ˣ���
 * ����2�����Ƶ���ɶ���ݽṹ���ռ任ʱ����,����Ȼ��Ҫ�õ�TreeSet
 * 	           �õ�TreeSet��sunSet����������set��ָ����Χ��Ԫ��
 *      ע��Խ������⣬�Լ�k��t�ĺϷ����ж�
 * 
 * 
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k<1||t<0||nums.length<2||nums==null) return false;
		SortedSet<Long> windows = new TreeSet<Long>();//����һ�����Ȳ�����k�Ļ�������
		for(int i=0;i<nums.length;i++){
			//��ǰ����nums[i]�ڴ������Ƿ�����������(����nums[i]-t, nums[i]+t+1��Χ�ڵ���)������
			SortedSet<Long> set = windows.subSet((long)(nums[i]-t), (long)nums[i]+t+1);
			if(!set.isEmpty()) return true;//�������ֱ�ӷ���true
			if(i>=k){//�жϴ��ڳ����Ƿ񳬹�k,���������ɾ�������������ȼ����Ԫ��
				windows.remove(nums[i-k]);
			}
			windows.add((long)nums[i]);
		}
		return false;
	}
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
       for(int i=0;i<nums.length;i++){
    	   for(int j=i+1;j<nums.length&&j<=i+k;j++){
    		   if(Math.abs(nums[i]-nums[j])<=t) return true;
    	   }
       }
       return false;
    }
}
