package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：从给定数组中重新排列各个数字，组成最大的数 [3, 30, 34, 5, 9] return 9534330
 * 分析1：归并排序
 *      将int数组转化为string数组，对String进行归并排序
 *      这里定义两个字符串的比较规则：t1=str1+st2 t2=str2+str1
 *      t1和t2逐位比较，若t1>t2 表示str1>str2,反之，str1<str2
 * 
 */
public class LargestNumber {
	@Test
	public void test(){
		int[] nums={0, 0, 0, 0, 9};
		String s = largestNumber(nums);
		System.out.println(s);
	}
    public String largestNumber(int[] nums) {
    	if(nums==null||nums.length==0) return "";
    	String[] str = new String[nums.length];
    	boolean isAllZero=true;
    	for(int i=0;i<nums.length;i++){//将int转化为string
    		if(nums[i]!=0) isAllZero=false;
    		str[i]=nums[i]+"";
    	}
    	if(isAllZero) return "0";
    	mergeSort(str,0,str.length-1);
    	StringBuilder sb = new StringBuilder();
    	for(int i=str.length-1;i>=0;i--){
    		sb.append(str[i]);
    	}
    	return sb.toString();
    }
    //若str1>str2 return true,否则return false
    public boolean compareTwoString(String str1,String str2){
    	String t1=str1+str2,t2=str2+str1;
    	int i=0;
    	while(i<t1.length()){
    		if(Integer.valueOf(t1.substring(i,i+1))>Integer.valueOf(t2.substring(i,i+1))) return true;
    		else if(Integer.valueOf(t1.substring(i,i+1))<Integer.valueOf(t2.substring(i,i+1))) return false;
    		else{
    			i++;
    		}
    	}
    	return false;
    }
    //归并排序
    public void mergeSort(String[] str,int l,int r){
    	if(l<r){
    		int m = (l+r)/2;
    		mergeSort(str,l,m);
    		mergeSort(str,m+1,r);
    		mergeArray(str,l,m,r);
    	}
    }
    public void mergeArray(String[] str,int l,int m,int r){
    	String[] tmp = new String[r-l+1];
    	int i=l,j=m+1,k=0;
    	while(i<=m&&j<=r){
    		if(compareTwoString(str[i],str[j])){//str[i]>str[j]
    			tmp[k++]=str[j++];
    		}else{
    			tmp[k++]=str[i++];
    		}
    	}
    	while(i<=m)tmp[k++]=str[i++];
    	while(j<=r)tmp[k++]=str[j++];
    	for(int a=l,p=0;a<=r;p++,a++){
    		str[a]=tmp[p];
    	}
    }
}
