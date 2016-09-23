package com.josh.task3;

import java.util.Stack;

import org.junit.Test;

public class SimplifyPath {

	@Test
	public void test(){
		String path = "/home/foo/.ssh/../.ssh2/authorized_keys/";
		simplifyPath(path);
	}
    public String simplifyPath(String path) {
    	int i=0;
    	Stack<String> stack = new Stack<String>();//�洢�򻯺��·��
    	while(i<path.length()){
    		if(stack.isEmpty() || !stack.peek().equals("/")){
    			stack.push(path.substring(i, i+1));
    		}
    		int j=i+1;
    		while(j<path.length() && path.charAt(j) != '/'){
    			j++;
    		}
    		if(i+1<j){
    			//�ж�����/ab/֮���ַ����Ƿ����Ҫ��
    			String temp = path.substring(i+1, j);
    			if(temp.equals(".")){
    				//do nothing
    			}else if(temp.equals("..") && !stack.isEmpty()){
    				stack.pop();//������һ��Ŀ¼����ջ
    				if(!stack.isEmpty()){
    					stack.pop();
    				}
    			}else{
    				stack.push(temp);
    			}
    		}
    		i = j;
    	}
    	if(stack.size()>1 && stack.peek().equals("/")){
    		stack.pop();
    	}
    	if(stack.isEmpty()){
    		stack.push("/");
    	}
    	String samplifyPath = "";
    	for(int k=0;k<stack.size();k++){
    		samplifyPath = samplifyPath + stack.get(k);
    	}
    	System.out.println(samplifyPath);
		return samplifyPath;
    }
}
