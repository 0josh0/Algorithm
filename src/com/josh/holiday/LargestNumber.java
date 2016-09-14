package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�Ӹ����������������и������֣���������� [3, 30, 34, 5, 9] return 9534330
 * ����1���鲢����
 *      ��int����ת��Ϊstring���飬��String���й鲢����
 *      ���ﶨ�������ַ����ıȽϹ���t1=str1+st2 t2=str2+str1
 *      t1��t2��λ�Ƚϣ���t1>t2 ��ʾstr1>str2,��֮��str1<str2
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
    	for(int i=0;i<nums.length;i++){//��intת��Ϊstring
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
    //��str1>str2 return true,����return false
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
    //�鲢����
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
