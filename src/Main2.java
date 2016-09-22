import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new TreeMap<String, Integer>();
		Scanner cin = new Scanner(System.in);
		int row = cin.nextInt();
		int count = 0;
		int k = 0;
		while (cin.hasNext()) {
			if (count <= row) {
				String[] str = cin.nextLine().split(" ");
				for (int i = 1; i < str.length; i++) {
					int value = 1;
					if (map.containsKey(str[i])) {
						value = map.get(str[i]) + 1;
					}
					map.put(str[i], value);
				}
			} else {
				k = cin.nextInt();
				break;
			}
			count++;
		}
		// 这里将map.entrySet()转换成list
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			// 降序排序
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}

		});
		int num = 0;
		for (Map.Entry<String, Integer> mapping : list) {
			if (num < k) {
				System.out.println(mapping.getKey() + " " + mapping.getValue());
				num++;
			} else {
				break;
			}
		}

	}
}
