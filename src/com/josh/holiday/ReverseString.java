package com.josh.holiday;
/*
 * ���⣺��ת�ַ��� Given s = "hello", return "olleh".
 * ����1������StringBuilder
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
