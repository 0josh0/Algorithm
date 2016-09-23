import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner cin = new Scanner(System.in);
		String str[] = cin.nextLine().split(" ");
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length; i++) {
			set.add(str[i]);// 将字符串存储在set中，用来判断是否存在O(1)
		}

		String longest = "";// 记录最长拼接字符串
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				// StringBuilder sb = new StringBuilder();
				// String tmp = str[i] + str[j];
				if (set.contains(str[i] + str[j])) {
					if ((str[i] + str[j]).length() > longest.length()) {
						longest = (str[i] + str[j]);
					}
				} else if (set.contains(str[j] + str[i])) {
					if ((str[j] + str[i]).length() > longest.length()) {
						longest = (str[j] + str[i]);
					}
				}
			}
		}
		System.out.println(longest);
	}
}
