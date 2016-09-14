package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��n��̨�ף�ÿ��ֻ����һ����������һ���ж������߷����ﶥ�ˡ�
 * ������1 ���������e.g.����8��̨�ף�1) 0��2����8��1��  1   -------------�˷������������ʱ��intԽ��
 * 							   2) 1��2����6��1��  C(7,1)
 * 							   3) 2��2����4��1��  C(6,2)
 * 							   4) 3��2����2��1��  C(5,3)
 * 							   5) 4��2����0��1��  C(4,4)
 *     2 ��̬�滮  ��ʼ״̬��D(1)=1,D(2)=2
 *              ״̬ת�ƣ�D(i)=D(i-1)+D(i-2)
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
    		//��C(a,b)
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
