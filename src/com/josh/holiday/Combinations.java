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
		//测试com
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
	 * Fun:求Cnk的组合数sum
	 * 递归时间
	 */
	public int com(int n,int k,int sum){
		if(k==0||k==n){
			return sum+1;
		}else{
			return com(n-1,k-1,sum)+com(n-1,k,sum);
		}
	}
	//相同思想
	/*
	 * 题意：求Cnk的所有组合数，并输出
	 * 分析：根据公式：Cnk = C(n-1)(k-1)+C(n-1)(k) 递推计算
	 */
	public List<List<Integer>> combine(int n, int k ) {
        if(k==0||k==n){//当k=n时，只有一种情况，从1-n，加入一个list
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i=1;i<=k;i++){
        		list.add(i);
        	}
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
        	res.add(list);//将这种结果存入res
        	return res;
        }
        List<List<Integer>> left = new ArrayList<List<Integer>>();
        left=combine(n-1, k-1);//计算C(n-1)(k-1)，将结果存在left中
        if(left.size()==0){//如果left为空，表示是Cn0这种情况，这时候新建一个list，把n添加进去，形成新left
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(n);
        	left.add(list);
        }else{//否则为left中每个list添加n
        	for(int i=0;i<left.size();i++){
        		left.get(i).add(n);
        	}
        }
        List<List<Integer>> right = new ArrayList<List<Integer>>();
        right=combine(n-1, k);//计算C(n-1)(k)，将结果存在right中
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<left.size();i++){//将left和right求和，放入最后结果res中
        	res.add(left.get(i));
        }
        for(int i=0;i<right.size();i++){
        	res.add(right.get(i));
        }
        return res;
    }
}
