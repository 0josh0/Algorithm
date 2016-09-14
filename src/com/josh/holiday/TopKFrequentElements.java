package com.josh.holiday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

/*
 * 题意：求一个数组中出现频率最高的前k个元素
 * 分析：map，存储key-元素，value-出现次数
 */
public class TopKFrequentElements {
	@Test
	public void test(){
		int[] nums={5,3,3,4,1,1,1,2,2,3};
		List<Integer> res = topKFrequent(nums, 3);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
	//用数组的下标表示元素出现的次数
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        	}else{
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        }
        //list型数组,下标表示出现元素的次数，数组中的list中存储的都是出现下标个数的元素
        List<Integer>[] array = new List [nums.length+1];
       
        for(Map.Entry<Integer, Integer> mapping :map.entrySet()){
        	if(array[mapping.getValue()]==null){//出现小标次数的元素第一次出现
        		List<Integer> subList = new ArrayList<Integer>();
        		subList.add(mapping.getKey());
        		array[mapping.getValue()]=subList;
        	}else{
        		array[mapping.getValue()].add(mapping.getKey());
        	}
        }
        for(int i=array.length-1;i>=0;i--){
        	if(list.size()==k) break;
        	if(array[i]!=null){
        		list.addAll(array[i]);
        	}
        }
		return list;
    }
	public List<Integer> topKFrequent1(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        	}else{
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        }
        //对TreeMap进行降序排序
        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(listMap,new Comparator<Map.Entry<Integer, Integer>>() {
        	//降序排序
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
        for(Map.Entry<Integer, Integer> mapping:listMap){
        	if(list.size()>=k) break;
        	list.add(mapping.getKey());
        }
		return list;
    }
}
