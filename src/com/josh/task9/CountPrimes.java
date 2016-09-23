package com.josh.task9;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ����: ����Ǹ�����n���ڵ������м���
 * ����: 1 ��ʱ
 *      2 ���һ����������������ô����������һ����֮ǰ���������������е���������������˵�����
 *        ���ԣ����Ѿ��õ���������������ÿ������Щ�����ж������Ƿ���������
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
    //���������������ô��������ܵĳ��������n/2
    public boolean isPrime(int n){
    	for(int i=2;i*i<=n;i++){
    		if(n%i==0) return false;
    	}
    	return true;
    }
}
