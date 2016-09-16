/**
 * 
 */
package com.josh.interview;

/**
 * @Title: DeleteRepeatString
 * @Description:删除重复字符。声明一个26大小的boolean数组，出现的位置置为true，需要异步转化，把string转化为小写
 * 
 * @author Summer
 * @date 2016年9月13日 下午3:34:24
 * 
 */
public class DeleteRepeatString {

	/**
	 * @Title:main
	 * @Description:TODO
	 * @param args
	 * @Author:Summer
	 * @Date:2016年9月13日
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "asfgrfeas";
		System.out.println(deleteRepeatStr(s));
	}

	public static String deleteRepeatStr(String s) {
		String str = s.toLowerCase();
		boolean[] flag = new boolean[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if (flag[index] == false) {
				sb.append(str.charAt(i));
				flag[index] = true;
			}
		}
		return sb.toString();
	}

}
