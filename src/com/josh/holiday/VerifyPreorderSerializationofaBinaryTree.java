package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * ���⣺������������л��������ķ�ʽ֮һ���������ǿսڵ�ʱ����¼�ڵ��ֵ������ǿսڵ㣬���ǽ����Ϊ#��
 * ���磬��Ŀ�����е������������������л�Ϊ�ַ��� "9,3,4,#,#,1,#,#,2,#,6,#,#"������#����սڵ㡣
 * ����һ�����ŷָ�ֵ�ַ�����У�����Ƿ���һ����ȷ�Ķ���������������л��ַ��������һ������Ҫ�ؽ������㷨��
 * ������ջ
 * 		����String���飬���ν�Ԫ����ջ��Ȼ���ж��Ƿ��ջ��������
 * 		���һ��ջ��Ԫ�ط�#������ջ
 * 		�������ջ��Ԫ����#����ջ��Ԫ��Ҳ��#���δ�ջ��Ԫ�ز���#����ջ3��Ԫ�أ���ջһ��#
 * 	          �������ջ��Ԫ����#����ջ��Ԫ��Ҳ��#���δ�ջ��Ԫ��Ҳ��#��return false
 * 		����ж�ջ��ֻʣһ��#��return true������return false��
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
