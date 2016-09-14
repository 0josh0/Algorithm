package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * 
 */
public class Combinations {

	@Test
	public void test(){
		//����com
		//System.out.println(com(5,2,0));
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = combine(5,4);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	/*
	 * Fun:��Cnk�������sum
	 * �ݹ�ʱ��
	 */
	public int com(int n,int k,int sum){
		if(k==0||k==n){
			return sum+1;
		}else{
			return com(n-1,k-1,sum)+com(n-1,k,sum);
		}
	}
	//��ͬ˼��
	/*
	 * ���⣺��Cnk������������������
	 * ���������ݹ�ʽ��Cnk = C(n-1)(k-1)+C(n-1)(k) ���Ƽ���
	 */
	public List<List<Integer>> combine(int n, int k ) {
        if(k==0||k==n){//��k=nʱ��ֻ��һ���������1-n������һ��list
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i=1;i<=k;i++){
        		list.add(i);
        	}
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
        	res.add(list);//�����ֽ������res
        	return res;
        }
        List<List<Integer>> left = new ArrayList<List<Integer>>();
        left=combine(n-1, k-1);//����C(n-1)(k-1)�����������left��
        if(left.size()==0){//���leftΪ�գ���ʾ��Cn0�����������ʱ���½�һ��list����n��ӽ�ȥ���γ���left
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(n);
        	left.add(list);
        }else{//����Ϊleft��ÿ��list���n
        	for(int i=0;i<left.size();i++){
        		left.get(i).add(n);
        	}
        }
        List<List<Integer>> right = new ArrayList<List<Integer>>();
        right=combine(n-1, k);//����C(n-1)(k)�����������right��
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<left.size();i++){//��left��right��ͣ����������res��
        	res.add(left.get(i));
        }
        for(int i=0;i<right.size();i++){
        	res.add(right.get(i));
        }
        return res;
    }
}
