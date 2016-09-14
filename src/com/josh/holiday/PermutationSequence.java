package com.josh.holiday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * 题意：给定整数n和k，1-n的全排列，返回第k个全排列
 * 分析：1、求出所有排列，然后排序，输出第k个 -- 此方法超时！
 *      2、不求所有排列,递归求解求1-（n-1）的阶乘 -- 还是超时
 *      3、基于2的改进算法，不用1到n-1每个数都求阶乘，只求出n-1的阶乘，然后需要的时候除以n-1就行了
 */
public class PermutationSequence {
	@Test
	public void test(){
//		String s = "123";
//		System.out.println(helper(s,6,new StringBuilder()));

		System.out.println(getPermutation(1,1));

	}
	public String getPermutation(int n, int k) {
		//求n-1阶乘
		double fact = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for(int i=2;i<=n;i++){
			if(i<n)fact=fact*i;
			sb.append(i);
		}
		if(k<1||k>fact*n) return "";
		if(k==1) return sb.toString();
		StringBuilder res = new StringBuilder();
		while(sb.length()>0){
			int up = (int) (Math.ceil(k/fact));//向上取整，加入res中的数字位置
			res.append(sb.substring(up-1,up));
			sb=sb.replace(up-1,up,"");//删除已经加入的数字
			k=(int) (k-(up-1)*fact);//更新k
			if(sb.length()>0)fact=fact/(sb.length());//更新fact(阶乘)
		}
		return res.toString();
	}
	public String getPermutation2(int n, int k) {
		//if(k<1||k>fact(n)) return "";
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++){
			sb.append(i);
		}
		return helper(sb.toString(),k,new StringBuilder());
	}
	public String helper(String str,int k,StringBuilder sb){
		if(str.length()==1){
			sb.append(str);
			return sb.toString();
		}else{
			double f = fact(str.length()-1);
			int up = (int) (Math.ceil(k/f));//向上取整
			sb.append(str.substring(up-1,up));
			k=(int) (k-(up-1)*f);
			str=str.replace(str.substring(up-1,up),"");
			helper(str,k,sb);
		}
		return sb.toString();
	}
	public int fact(int n){//求n的阶乘
		int res=1;
		for(int i=1;i<=n;i++){
			res=res*i;
		}
		return res;
	}
	public String getPermutation1(int n, int k) {
		int up=1;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++){
			up=up*i;//求n的阶乘
        	sb.append(i);
        }
		if(k==1)return sb.toString();
		if(k==up) return sb.reverse().toString();
		int[] array = new int[n];
		for(int i=0;i<n;i++){//将n个数存入array数组中
			array[i]=i+1;
		}
		List<Integer> list = new ArrayList<Integer>();
		per(array,0,array.length-1,list);
		Collections.sort(list);
		return list.get(k-1)+"";
    }
	public void per(int[] array,int start,int end,List<Integer> res){
		if(start==end){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<array.length;i++){
				sb.append(array[i]);
			}
			res.add(Integer.valueOf(sb.toString()));
		}else{
			for(int i=start;i<=end;i++){
				int temp = array[start];//交换start元素和其之后的元素
				array[start] = array[i];
				array[i] = temp;
				per(array,start+1,end,res);
				temp = array[start];//交换回来
				array[start] = array[i];
				array[i] = temp;
			}
		}
	}
}
