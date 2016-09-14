package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺ʵ���������ĳ˷����㣬�����ó˷���������ȡģ����
 * ������1���ü���ʵ�� -- ����ĥ���ܻᳬʱ,��Ȼ���������ϣ���ʱ�ˣ���
 *      2���ݹ飬�������
 */
public class DivideTwoIntegers {
	@Test
	public void test(){
		System.out.println(divide(-2147483648,-1109186033));
//		System.out.println(Integer.MAX_VALUE/2);
//		System.out.println(Math.abs(-2147483647));
	}
    public int divide(int dividend, int divisor) {
    	if(divisor==dividend) return 1; 
    	if(dividend==Integer.MIN_VALUE&&divisor==Integer.MAX_VALUE) return -1; 
        if(divisor==1) return dividend;
        if(divisor==-1) return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
        if(dividend==0||divisor==Integer.MIN_VALUE||(dividend!=Integer.MIN_VALUE&&Math.abs(dividend)<Math.abs(divisor))) return 0;
        boolean flag=true,isMinInteger=false;//�����ͱ�����ͬ��
    	if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) flag=false;
        if(dividend==Integer.MIN_VALUE){
        	if(flag) dividend=dividend-divisor;
        	else dividend=dividend+divisor;
        	isMinInteger=true;
        }//ȫ��ת��Ϊ������������
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        if(isMinInteger){
        	return flag?helper(dividend,divisor,1):-helper(dividend,divisor,1);
        }
        return flag?helper(dividend,divisor,0):-helper(dividend,divisor,0);
        
    }
    public int helper(int dividend,int divisor,int res){//�鵰������ֻ���������ĳ���
    	if(dividend<divisor) return res;
    	int sor=divisor,count=0;
    	while(sor<1073741824&&dividend>sor+sor){
    		sor=sor+sor;
    		count++;
    	}
    	res+=1<<count;
    	dividend=dividend-sor;
    	if(dividend==divisor){
    		return res+1;
    	}else if(dividend>divisor){
    		return helper(dividend,divisor,res);
    	}else{
    		return res;
    	}
    }
}
