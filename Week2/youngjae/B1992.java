import java.util.Scanner;

public class B1992 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		QuardTree(0, 0, N);
		System.out.println(sb);

	}

	static void QuardTree(int x, int y, int size) {
		if (visited(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}

		int slice = size / 2;
		sb.append('(');

		QuardTree(x, y, slice);
		QuardTree(x, y + slice, slice);
		QuardTree(x + slice, y, slice);
		QuardTree(x + slice, y + slice, slice);

		sb.append(')');
	}

	// 이게 current랑 비교햇을 때 size만큼의 박스가 다 같은 놈들인지
	static boolean visited(int x, int y, int size) {
		int current = arr[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != current) {
					return false;
				}
			}
		}
		return true;
	}

}
