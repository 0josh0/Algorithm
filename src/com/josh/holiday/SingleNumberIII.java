package com.josh.holiday;

import org.junit.Test;

/*
 * ����: �����е�ÿһ��Ԫ�ض��������Σ�ֻ����������һ�Σ��ҳ�����������һ�ε�Ԫ��
 * ����: λ������ȫ��������õ���������ͬ���������
 * 		����������������У��Ӻ���ǰ�ҵ���һ��λ��Ϊ1��λi���ݴ˷�����
 *      ���1��һ������������ͬ����������γɵģ���Ϊ�������ֶ��ǳɶԳ��֣�
 *      �������λ�ϵĽ����ȻΪ0������1һ������������ͬ�����ֲ����ġ�
 *      Ȼ�����nums������Ԫ�أ����ݵ�iλ����1��0���ֳ������֣�ת��ΪSingleNumberI�е�����
 *      �����ҵ��������֡�
 */
public class SingleNumberIII {
	@Test
	public void test(){
		int[] array = {0,1,2,1};
		int[] a = new int[2];
		a=singleNumber(array);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		//System.out.println((-2)&(2));
	}
	public int[] singleNumber(int[] nums) {
		int res =0;
		int[] a = new int[2];
 		for(int i=0;i<nums.length;i++){
			res^=nums[i];
		}
 		
 		int firstIndex=1;//�ҵ�res��һ������1��λ
 		while((res&1)==0){
 			res = res>>1;
 			firstIndex++;
 		}
 		//���ݵ�firstIndexλ���Ƿ�Ϊ1���������
		for(int i=0;i<nums.length;i++){
			if(((nums[i]>>(firstIndex-1))&1)==0){
				a[0]^= nums[i];
			}else{
				a[1]^= nums[i];
			}
		}
		return a;
    }
}
