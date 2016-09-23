package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺���Ǹ�����n�������0-n��ÿ�����Ķ������м���1��For num = 5 you should return [0,1,1,2,1,2].
 * ���������������֣�1�ĸ��������¹��ɣ�2����������1��������2���ݣ���ô����ǰһ��2���ݺ���һ������ӵõ���1�ĸ���Ҳ���������֮��
 * 	   1���жϵ�ǰ���Ƿ���2���ݣ����ǣ�1�ĸ���Ϊ1�������ǣ�����ڶ���
 *     2����ǰ1�ĸ�����ǰһ��2��������1�ĸ�����1��������һ����֮��
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
