import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int paramNums = Integer.valueOf(cin.nextLine());// ��ȡ��������
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();// �洢ÿ���������ܵ����

		// ��ÿ�������Ŀ������
		for (int i = 0; i < paramNums; i++) {
			String[] line1 = cin.nextLine().split(" ");
			String[] line2 = cin.nextLine().split(",");
			ArrayList<String> subList = new ArrayList<String>();
			subList = getOneAll(line1, line2);
			list.add(subList);
		}
		// ÿ����������鲢
		ArrayList<String> pre = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			ArrayList<String> cur = list.get(i);
			ArrayList<String> tmp = new ArrayList<String>();// �洢�����鲢���
			for (int j = 0; j < pre.size(); j++) {
				for (int k = 0; k < cur.size(); k++) {

					if (cur.get(k).equals("")) {
						tmp.add(pre.get(j));
					} else {
						String[] str = { pre.get(j), cur.get(k) };
						Arrays.sort(str);
						tmp.add(str[0] + "&" + str[1]);
					}
				}
			}
			pre = tmp;
		}
		String[] ss = new String[pre.size()];
		for (int i = 0; i < pre.size(); i++) {
			ss[i] = pre.get(i);
		}
		Arrays.sort(ss);
		// ������п��ܽ��
		print(pre);
	}

	// ��ȡһ�����������п������
	public static ArrayList<String> getOneAll(String[] line1, String[] line2) {
		ArrayList<String> subList = new ArrayList<String>();

		ArrayList<String> allValue = new ArrayList<String>();
		for (int i = 0; i < line2.length; i++) {
			allValue.add(line2[i]);
		}
		String name = line1[0];
		// �ж��Ƿ�Ϊ����
		if (line1[1].equals("0")) {
			subList.add("");
		}
		// �ж��Ƿ�ɸ�
		if (line1[3].equals("1")) {
			for (int i = 0; i < line2.length; i++) {
				allValue.add("-" + line2[i]);
			}
		}
		// �ж��Ƿ�ɶ�ֵ
		if (line1[2].equals("1")) {// ֵ����Ϊ��ֵ
			ArrayList<String> com = Combination(allValue);
			for (int j = 0; j < com.size(); j++) {
				String param = name + "=" + com.get(j);
				subList.add(param);
			}
		} else {// ֻ�ܴ���ֵ
			for (int j = 0; j < allValue.size(); j++) {
				String param = name + "=" + allValue.get(j);
				subList.add(param);
			}
		}
		return subList;
	}

	// �������в���
	public static void print(ArrayList<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}

	// ��ֵ��ȫ����
	public static ArrayList<String> Combination(ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<String>();
		String[] str = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			str[i] = list.get(i);
		}
		int n = str.length;
		int nbit = 1 << n;

		for (int i = 1; i < nbit; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				int tmp = 1 << j;
				if ((tmp & i) != 0) {
					// System.out.print(str[j]);
					sb.append(str[j] + ",");
				}
			}
			res.add(sb.toString().substring(0, sb.length() - 1));
		}
		return res;
	}
}
