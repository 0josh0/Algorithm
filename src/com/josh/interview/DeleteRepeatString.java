/**
 * 
 */
package com.josh.interview;

/**
 * @Title: DeleteRepeatString
 * @Description:ɾ���ظ��ַ�������һ��26��С��boolean���飬���ֵ�λ����Ϊtrue����Ҫ�첽ת������stringת��ΪСд
 * 
 * @author Summer
 * @date 2016��9��13�� ����3:34:24
 * 
 */
public class DeleteRepeatString {

	/**
	 * @Title:main
	 * @Description:TODO
	 * @param args
	 * @Author:Summer
	 * @Date:2016��9��13��
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
