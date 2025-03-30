import java.util.Scanner;

public class B16719 {
	// 16719 - ZOAC
	// 입력받은 문자열을 낮은 순서로 하나씩 추가해서 첨부

	// 길이의 반으로 나누어 분할정복
	// 고른걸 기준으로 나누어줌
	static String str;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		selected = new boolean[str.length()];
		zoac(0, str.length() - 1);
	}

	static void zoac(int left, int right) {
		if (left > right) {
			return;
		}
		int idx = -1;
		char min = 'Z' + 1;

		for (int i = left; i <= right; i++) {
			if (!selected[i] && str.charAt(i) < min) {
				min = str.charAt(i);
				idx = i;
			}
		}

		selected[idx] = true;

		for (int i = 0; i < str.length(); i++) {
			if (selected[i])
				System.out.print(str.charAt(i));
		}
		System.out.println();

		zoac(idx + 1, right);
		zoac(left, idx - 1);
	}
}
