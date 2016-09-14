package com.josh.task9;

import java.util.ArrayList;

import org.junit.Test;

/*
 * ����: �������������ֱ������Ӻͷ�ĸ���������С����ʽ,����ѭ��С������ѭ����������������
 * ����: ����һ����ĸΪN��ѭ��С����ѭ����λ����಻����N-1λ��
 */
public class FractionRecurringDecimal {
	@Test
	public void test(){
		System.out.println(fractionToDecimal(-1,-2147483647));
	}
    public String fractionToDecimal(int numerator, int denominator) {
    	if(numerator==0) return "0";
        long a = numerator,b=denominator;
        long numerator1=Math.abs(a);
        long denominator1=Math.abs(b);//ȫ��ת��Ϊ��������
        ArrayList<Long> list = new ArrayList<Long>();//�洢���ظ����ֵ�����
        String res = (numerator1/denominator1)+"";//������������
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)) res="-"+res;
        StringBuffer sb = new StringBuffer();//����С������
        long m = numerator1%denominator1;//��������
        if(m==0) return res;
        while(m!=0){
        	if(list.contains(m)){//�������򼯺����������������ʾ�Ѿ������ظ���������ѭ��
        		int i=0;
        		for(;i<list.size();i++){//Ѱ��ѭ�������
        			if(list.get(i)==m) break;
        		}
        		sb.insert(i, "(");
        		sb.insert(list.size()+1, ")");
        		break;//����whileѭ��
        	}else{//û�г���������������С������
        		list.add(m);//��set���������������
        		sb.append(m*10/denominator1);
        		m=m*10%denominator1;//��������
        	}
        }
        return res+"."+sb;
    }
}
