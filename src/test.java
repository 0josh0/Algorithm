import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String[] line1 = cin.nextLine().split(" ");
			// String[] line2 = cin.nextLine().split(" ");
			int n = Integer.valueOf(line1[0]);// �������
			int k = Integer.valueOf(line1[1]);// ��ӰԺ��С-k
			int[][] move = new int[k][k];// ��ʼ����ӰԺ��λ
			double xc = Math.ceil(k / 2);
			double yc = Math.ceil(k / 2);// ����λ��

			String[] line2 = cin.nextLine().split(" ");// ��ȡn�ι����ÿ�ι�������
			// int[] by = new int[line2.length];
			for (int i = (int) (xc - 1); i >= 0; i--) {// ת��Ϊ����
				// by[i] = Integer.valueOf(line2[i]);
				int yl = (int) yc, yr = (int) yc;
				hasEnoughSites(move, i, Integer.valueOf(line2[i]), (int) xc, yl, yr);
			}
			for (int i = (int) (xc); i < line2.length; i++) {// ת��Ϊ����
				// by[i] = Integer.valueOf(line2[i]);
				int yl = (int) yc, yr = (int) yc;
			}

		}
	}

	public static boolean hasEnoughSites(int[][] move, int x, int count, int xc, int yl, int yr) {
		int left = 0, right = 0, dis = Integer.MAX_VALUE;
		for (int i = 0; i < move.length; i++) {
			left = i;
			int num = 0;
			boolean f = false;
			for (int j = i; j < move.length; j++) {
				if (num == count) {
					right = j;
					f = true;
					break;
				}
				if (move[x - 1][j] == 0) {
					num++;
				} else {
					break;
				}
			}
			if (f) {
				int tmp = Math.abs((xc - 1 - left)) + Math.abs((xc - 1 - right));
				if (dis > tmp) {
					yl = left;
					yr = right;
					dis = tmp;
				}
				/// dis=Math.min(dis, tmp);
			}
		}
		if (dis < Integer.MAX_VALUE) {
			return true;
		}
		return false;
	}

}
