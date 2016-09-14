package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意：先序遍历是序列化二叉树的方式之一。当遇到非空节点时，记录节点的值。如果是空节点，我们将其记为#。
 * 例如，题目描述中的样例二叉树可以序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中#代表空节点。
 * 给定一个逗号分隔值字符串，校验其是否是一个正确的二叉树先序遍历序列化字符串。设计一个不需要重建树的算法。
 * 分析：栈
 * 		遍历String数组，依次将元素入栈，然后判断是否出栈，出几个
 * 		情况一：栈顶元素非#，不出栈
 * 		情况二：栈顶元素是#，次栈顶元素也是#，次次栈顶元素不是#，出栈3个元素，入栈一个#
 * 	          情况三：栈顶元素是#，次栈顶元素也是#，次次栈顶元素也是#，return false
 * 		最后判断栈中只剩一个#，return true，否则，return false；
 *   
 */
public class VerifyPreorderSerializationofaBinaryTree {
	@Test
	public void test(){
		String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		//String str = "1,#,#,#,#"; 
		System.out.println(isValidSerialization(str));
	}
	public boolean isValidSerialization(String preorder) {
        String[] sPreorder = preorder.split(",");
        if(sPreorder.length==1&&sPreorder[0].equals("#")) return true;
        if(sPreorder.length<3) return false;
        Stack<String> stack = new Stack<String>();
        stack.push(sPreorder[0]);
        stack.push(sPreorder[1]);
        for(int i=2;i<sPreorder.length;i++){
        	stack.push(sPreorder[i]);
        	while(stack.size()>2&&stack.peek().equals("#")&&stack.get(stack.size()-2).equals("#")){
        		if(stack.get(stack.size()-3).equals("#")) return false;
        		stack.pop();
    			stack.pop();
    			stack.pop();
    			stack.push("#");                                                                
        	}
        }
		return (stack.size()==1&&stack.peek().equals("#"))?true:false;
    }
}
