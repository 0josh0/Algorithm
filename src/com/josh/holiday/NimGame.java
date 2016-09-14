package com.josh.holiday;

/*
 * Nim Game：有一堆石头在桌子上，每次只能拿走1、2或者3个，最后拿走桌上石头的人获胜，第一次由"我"先拿
 * 分析：每一个石头的数目都对应一个状态：输或者赢。输状态是4、8、12……即4的倍数，其他数目为赢状态
 */
public class NimGame {
    public boolean canWinNim(int n) {
    	if(n%4==0)
    		return false;
    	else
    		return true;
    }
}
