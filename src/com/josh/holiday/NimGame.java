package com.josh.holiday;

/*
 * Nim Game����һ��ʯͷ�������ϣ�ÿ��ֻ������1��2����3���������������ʯͷ���˻�ʤ����һ����"��"����
 * ������ÿһ��ʯͷ����Ŀ����Ӧһ��״̬�������Ӯ����״̬��4��8��12������4�ı�����������ĿΪӮ״̬
 */
public class NimGame {
    public boolean canWinNim(int n) {
    	if(n%4==0)
    		return false;
    	else
    		return true;
    }
}
