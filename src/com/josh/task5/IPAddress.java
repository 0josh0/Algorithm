package com.josh.task5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * 用三个指针分别标记IP地址中的三个点的位置
 * 移动指针来判断可以分成多少个IP地址
 * 
 */
public class IPAddress {

	@Test
	public void test(){
		String s = "010010";
		List<String> ipAddresses = restoreIpAddresses(s);
		if(ipAddresses.isEmpty())
			System.out.println("IP地址null");
		for(int i=0;i<ipAddresses.size();i++){
			System.out.println(ipAddresses.get(i));
		}
			
		
	}
    public List<String> restoreIpAddresses(String s) {
		List<String> ipAddresses = new ArrayList<String>();
    	if(s.length()<4 || s.length()>12) return ipAddresses;
    	for(int i=0;i<3;i++){
    		for(int j=i+1;j<6;j++){
    			for(int k=j+1;k<9;k++){
    				//if(k < s.length()-1 && Integer.parseInt(s.substring(0,i+1)) < 256 && Integer.parseInt(s.substring(i+1,j+1)) < 256 && Integer.parseInt(s.substring(j+1,k+1)) < 256 && Integer.parseInt(s.substring(k+1,s.length())) < 256){
    				if(k < s.length()-1 && isIp(s.substring(0,i+1)) && isIp(s.substring(i+1,j+1)) && isIp(s.substring(j+1,k+1)) && isIp(s.substring(k+1,s.length()))){
    	    			String ip = s.substring(0,i+1)+"."+s.substring(i+1,j+1)+"."+s.substring(j+1,k+1)+"."+s.substring(k+1,s.length());
    	    			ipAddresses.add(ip);
    	    		}
    			}
    		}
    	}
    	return ipAddresses;
    }
    public boolean isIp(String s){
    	if((Integer.parseInt(s)==0 && s.length()==1) || (Integer.parseInt(s)<256 && !s.substring(0,1).equals("0"))){
    		return true;
    	}
    	else
    		return false;
    }
}
