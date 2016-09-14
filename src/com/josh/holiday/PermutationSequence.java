package com.josh.holiday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺��������n��k��1-n��ȫ���У����ص�k��ȫ����
 * ������1������������У�Ȼ�����������k�� -- �˷�����ʱ��
 *      2��������������,�ݹ������1-��n-1���Ľ׳� -- ���ǳ�ʱ
 *      3������2�ĸĽ��㷨������1��n-1ÿ��������׳ˣ�ֻ���n-1�Ľ׳ˣ�Ȼ����Ҫ��ʱ�����n-1������
 */
public class PermutationSequence {
	@Test
	public void test(){
//		String s = "123";
//		System.out.println(helper(s,6,new StringBuilder()));

		System.out.println(getPermutation(1,1));

	}
	public String getPermutation(int n, int k) {
		//��n-1�׳�
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
			int up = (int) (Math.ceil(k/fact));//����ȡ��������res�е�����λ��
			res.append(sb.substring(up-1,up));
			sb=sb.replace(up-1,up,"");//ɾ���Ѿ����������
			k=(int) (k-(up-1)*fact);//����k
			if(sb.length()>0)fact=fact/(sb.length());//����fact(�׳�)
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
			int up = (int) (Math.ceil(k/f));//����ȡ��
			sb.append(str.substring(up-1,up));
			k=(int) (k-(up-1)*f);
			str=str.replace(str.substring(up-1,up),"");
			helper(str,k,sb);
		}
		return sb.toString();
	}
	public int fact(int n){//��n�Ľ׳�
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
			up=up*i;//��n�Ľ׳�
        	sb.append(i);
        }
		if(k==1)return sb.toString();
		if(k==up) return sb.reverse().toString();
		int[] array = new int[n];
		for(int i=0;i<n;i++){//��n��������array������
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
				int temp = array[start];//����startԪ�غ���֮���Ԫ��
				array[start] = array[i];
				array[i] = temp;
				per(array,start+1,end,res);
				temp = array[start];//��������
				array[start] = array[i];
				array[i] = temp;
			}
		}
	}
}
