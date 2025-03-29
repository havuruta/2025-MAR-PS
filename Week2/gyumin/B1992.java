package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1992 {
	static int[][] quadTree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		quadTree = new int[n][];

		for (int i = 0; i < n; i++) {
			quadTree[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		} // 여기서 입력 끝

		sb = new StringBuilder();

		press(0, n, 0, n); // 압축 시작
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}

	private static void press(int rs, int re, int cs, int ce) {
		int target = quadTree[rs][cs];

		boolean needRecall = false;
		for (int i = rs; i < re; i++) {
			for (int j = cs; j < ce; j++) {
				if (quadTree[i][j] != target) {
					needRecall = true;
					break;
				}
			}
			if (needRecall)
				break;
		} // 검사 과정

		if (needRecall) {
			int rowMid = (rs + re) / 2;
			int colMid = (cs + ce) / 2;
			sb.append("(");
			press(rs, rowMid, cs, colMid); // 좌상
			press(rs, rowMid, colMid, ce); // 우상
			press(rowMid, re, cs, colMid); // 좌하
			press(rowMid, re, colMid, ce); // 우하
			sb.append(")");
		} else
			sb.append(target);
	} // 압축 과정
}
