package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ����: ֻ���һ�С�e.g. ����n=3�����{1,3,3,1}
 * ����: ��Ϊ��ǰ��Ԫ����ǰһ�в���������������list�ֱ𱣴浱ǰ�к���һ��Ԫ�ء�
 */
public class PascalTriangleII {
	@Test
	public void test(){
		List<Integer> list = new ArrayList<Integer>();
		list = getRow(4);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> preList = new ArrayList<Integer>();
        if(rowIndex<0) return list;
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
        	//����һ��Ԫ�ش洢��preList��
        	for(int k=0;k<list.size();k++){
        		preList.add(list.get(k));
        	}
        	list.clear();//���list
        	list.add(1);
        	for(int j=1;j<i;j++){
        		list.add(preList.get(j-1)+preList.get(j));
        	}
        	preList.clear();
        	list.add(1);
        }
		return list;
    }
}
