package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：给非负整数n，计算从0-n的每个数的二进制有几个1，For num = 5 you should return [0,1,1,2,1,2].
 * 分析：经分析发现，1的个数有如下规律：2的幂数就是1个，不是2的幂，那么由其前一个2的幂和另一个数相加得到，1的个数也是这个两个之和
 * 	   1、判断当前数是否是2的幂，若是，1的个数为1，若不是，进入第二步
 *     2、当前1的个数是前一个2的幂数的1的个数（1个）和另一个数之和
 */
public class CountingBits {
	@Test
	public void test(){
		int[] res = countBits(5);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
    public int[] countBits(int num) {
        int[] res = new int[num-0+1];
        //if(num>0) res[1] = 1;
        //int two=2;
        int mi=0;
        for(int i=1;i<=num;i++){
        	if(i==Math.pow(2, mi)){
        		res[i]=1;
        		mi++;
        	}else{
        		res[i]=res[(int) Math.pow(2, mi-1)]+res[(int) (i-Math.pow(2, mi-1))];
        	}
        }
        return res;
    }
}
