package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2630 {
	static int[] count;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		paper = new int[n][];
		count = new int[2]; // [0]: 하양, [1]: 파랑

		for (int i = 0; i < n; i++) {
			paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} // 여기서 입력 끝

		divide(0, n, 0, n);

		int white = count[0];
		int blue = count[1];

		bw.write(white + "\n" + blue);
		bw.flush();

		br.close();
		bw.close();
	}

	private static void divide(int rs, int re, int cs, int ce) {
		int color = paper[rs][cs]; // 여기서 0 이 오면 하양, 1이 오면 파랑인지 검사를 해
		boolean needRecall = false;

		for (int i = rs; i < re; i++) {
			for (int j = cs; j < ce; j++) {
				if (paper[i][j] != color) {
					needRecall = true;
				}
			}
		} // 검사 완료

		if (needRecall) {
			int rowMid = (rs + re) / 2;
			int colMin = (cs + ce) / 2;
			divide(rs, rowMid, cs, colMin); // 좌상
			divide(rs, rowMid, colMin, ce); // 우상
			divide(rowMid, re, cs, colMin); // 좌하
			divide(rowMid, re, colMin, ce); // 우하
		} else
			count[color]++;
	}
}
