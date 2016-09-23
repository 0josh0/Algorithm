package com.josh.holiday;

import java.util.Iterator;

/*
 * ���⣺����һ����������ӿڣ���������: next()��hasNext()����Ʋ�ʵ��һ��PeekingIterator֧��peek()����
 *  -- �䱾�ʾ��ǰ�ԭ��Ӧ��next()�������ص�Ԫ��peek()������
 *  ������һ�����ӡ������������ʼ��Ϊlist��[1, 2, 3]��
 *  ����next()�õ�1���б�ĵ�һ��Ԫ�ء�
 *  ���ڵ���peek()Ȼ�󷵻�2����һ��Ԫ�ء��ڴ�֮�����next()��Ȼ����2��
 *  ���һ�ε���next()����3��ĩβԪ�ء��˺����hasNext()Ӧ�÷���false��
 *  
 *  ������next�൱��һ��ָ�룬ָ��ǰlist�еĵ�һ��Ԫ��
 *  	ʵ�ʾ���Ϊԭ���ĵ����������һ��peek��������ô��Ҫ��һ����������¼next()ָ���Ԫ�أ�
 *  	�����next()�ٴ�ִ��֮ǰִ��peek��ֱ��return�������ݼ���
 *  	�����next()�ٴ�ִ��֮��ִ��peek����ô��ִ��next��ʱ��Ҫ���»���
 */
public class PeekingIterator implements Iterator<Integer>{

	Iterator<Integer> iterator; //������
	Integer peekElement = null;//����nextָ���ƶ���ʱ��ԭ��ָ���Element
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    this.peekElement = iterator.next();
	}
	
	public Integer peek() {
		return peekElement;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return iterator.hasNext()||peekElement!=null;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		Integer res = peekElement;
		peekElement = iterator.hasNext()?iterator.next():null;
		return res;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
