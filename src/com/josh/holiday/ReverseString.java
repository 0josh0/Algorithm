package com.josh.holiday;
/*
 * 题意：翻转字符串 Given s = "hello", return "olleh".
 * 分析1：利用StringBuilder
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
