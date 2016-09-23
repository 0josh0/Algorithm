import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class param implements Comparable<param> {
		boolean must;
		boolean mul;
		boolean minus;
		String param;
		String[] values;

		@Override
		public int compareTo(param o) {
			return param.compareTo(o.param);
		}
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int i = 0;
		param[] params = new param[n];
		for (; i < n; i++) {
			param p = new param();
			p.param = cin.next();
			p.must = (cin.nextInt() == 1);
			p.mul = (cin.nextInt() == 1);
			p.minus = (cin.nextInt() == 1);
			String value = cin.next();
			p.values = value.split(",");
			params[i] = p;
		}
		cin.close();
		gen(params);

	}

	private static void gen(param[] ps) {
		Arrays.sort(ps);
		geni(ps, 0, 2, "");

	}

	private static void geni(param[] ps, int i, int total, String path) {
		if (i == total) {
			System.out.println(path);
			return;
		}
		if (!path.equals(""))
			path += "&";
		if (ps[i].mul) {
			List<String> re = new ArrayList<>();
			genv(ps[i].values, re, 0, "", ps[i].minus);
			Collections.sort(re);
			for (String v : re) {
				geni(ps, i + 1, total, path + ps[i].param + "=" + v);
			}
		} else {
			if (ps[i].minus) {
				for (String v : ps[i].values) {
					geni(ps, i + 1, total, path + ps[i].param + "=-" + v);
				}
			}
			for (String v : ps[i].values) {
				geni(ps, i + 1, total, path + ps[i].param + "=" + v);
			}
		}
		if (!ps[i].must) {
			geni(ps, i + 1, total, path);
		}

	}

	private static void genv(String[] vs, List<String> result, int i, String path, boolean minus) {
		if (i == vs.length) {
			if (path.equals("")) {
				return;
			}
			result.add(path);
			return;
		}
		genv(vs, result, i + 1, path, minus);
		if (!path.equals(""))
			path += ",";
		if (minus) {
			genv(vs, result, i + 1, path + "-" + vs[i], minus);
		}
		genv(vs, result, i + 1, path + vs[i], minus);
	}
}