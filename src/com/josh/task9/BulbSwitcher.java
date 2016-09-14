package com.josh.task9;

import org.junit.Test;

/*
 * ����: ��������n����ʾ��nյ�ƣ���ʼ��ȫ���رգ���һ��ȫ���򿪣�
 *      �ڶ��֣��ر�����2�ı�����λ�õĵƣ������֣��ر�����3�ı�����λ�õĵƣ����Ѿ�off���ı�Ϊon��
 *      ���һ�֣�ֻ�ı����һյ�Ƶ�״̬��
 *      �����һ�ֺ��ж���յ��on��
 * ����: 1 �ı�һ��״̬��������1�����ͳ��.ʱ�临�Ӷ�O(n2) -- �����������ò��˸��붼֪���϶���ʱ����
 *      2 ��ÿ��λ�ö�Ӧ���ֵķֽ����� -- ���ǳ�ʱ���������Ż�������ô�Ѿ�����
 *      3 ͨ��ʵ�鷢�֣��������Ƶ�λ�ö���ƽ������λ�ã�e.g.1-4-9�������Դ���ת��Ϊ��n����ƽ�����ĸ���
 */

public class BulbSwitcher {
	@Test
	public void test(){
		System.out.println(bulbSwitch(5));
	}
	public int bulbSwitch(int n) {
		return (int)Math.sqrt(n);
	}
	public int bulbSwitch2(int n) {
		if(n==0) return 0;
		int[] bulb = new int[n];
		for(int i=1;i<n;i++){
			bulb[i]++;
			for(int j=2;j<=(i+1)/2;j++){
				if((i+1)%j==0) bulb[i]++;
			}
		}
		int count=0;
    	for(int k=0;k<n;k++){
    		if(bulb[k]%2==0) count++;
    	}
    	return count;
	}
    public int bulbSwitch1(int n) {
    	if(n==0) return 0;
        int[] bulb = new int[n];
    	for(int i=1;i<n;i++){
    		int m=i+1;
        	for(int j=i;j<n;j++){
        		if((j+1)%m==0)bulb[j]++;
        	}
        }
    	int count=0;
    	for(int k=0;k<n;k++){
    		if(bulb[k]%2==0) count++;
    	}
    	return count;
    }
}
