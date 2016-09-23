package com.josh.task9;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意: 计算非负整数n以内的质数有几个
 * 分析: 1 超时
 *      2 如果一个数不是质数，那么他的因子中一定有之前的质数，即，所有的数都是由质数相乘得来的
 *        所以，把已经得到的质数存起来，每次用这些质数判断新数是否是质数。
 */
public class CountPrimes {
    @Test
    public void test(){
    	//int n=13;
    	System.out.println(countPrimes(3));
    }
	public int countPrimes(int n) {
		if(n<=2) return 0;
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(2);
    	for(int i=3;i<n;i++){
    		boolean flag = true;
    		for(int j=0;list.get(j)*list.get(j)<=i;j++){
    			if(i%list.get(j)==0){
    				flag=false;
    				break;
    			}
    		}
    		if(flag==true){
    			list.add(i);
    		}
    	}
        return list.size();
    }
	public int countPrimes1(int n) {
    	int count = 0;
    	for(int i=2;i<n;i++){
    		if(isPrime(i)) count ++;
    	}
        return count;
    }
    //如果不是质数，那么这个数可能的乘数最大是n/2
    public boolean isPrime(int n){
    	for(int i=2;i*i<=n;i++){
    		if(n%i==0) return false;
    	}
    	return true;
    }
}
