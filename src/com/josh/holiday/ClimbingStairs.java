package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：有n个台阶，每次只能走一个或俩个，一共有多少种走法到达顶端。
 * 分析：1 求组合数。e.g.共有8个台阶：1) 0个2步，8个1步  1   -------------此方法在求组合数时，int越界
 * 							   2) 1个2步，6个1步  C(7,1)
 * 							   3) 2个2步，4个1步  C(6,2)
 * 							   4) 3个2步，2个1步  C(5,3)
 * 							   5) 4个2步，0个1步  C(4,4)
 *     2 动态规划  初始状态：D(1)=1,D(2)=2
 *              状态转移：D(i)=D(i-1)+D(i-2)
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
    	if(n<=0) return 0;
    	if(n==1||n==2) return n;
    	int d1=1,d2=2,di=3,i=3;
    	while(i<=n){
    		di=d1+d2;
    		d1=d2;
    		d2=di;
    		i++;
    	}
        return di;
    }
    public int climbStairs1(int n) {
    	int res = 0,count = n/2;
    	if(n==0) return res;
    	for(int i=0;i<=count;i++){
    		//求C(a,b)
    		res = res + combineNum(n-i,i);
    	}
        return res;
    }
    public int combineNum(int n,int m){
    	if(m>n/2) m=n-m;
    	if(m==n || m==0) return 1;
    	int b=m-1,a=n-1,c=n-m;
    	while(a>c){
    		n = n*a;
    		a=a-1;
    	}
    	while(b>0){
    		m = m*b;
    		b=b-1;
    	}
    	return n/m;
    }
    @Test
    public void test(){
 //   	int res = 0;
//    	for(int i =0;i<23;i++){
//    		System.out.println(combineNum(44-i,i));
//    		res = res+combineNum(44-i,i);
//    	}
    	System.out.println(climbStairs(44));
//    	System.out.println("sum = "+res);
    	//System.out.println(combineNum(30,14));
    }

}
