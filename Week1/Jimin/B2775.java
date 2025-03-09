// 문제: 2775 부녀회장이 될테야
// 설명: 특정 규칙에 따라 아파트 거주민 수를 구하는 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			bw.write(부녀회장(k, n) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	public static int 부녀회장(int k, int n) {
		int[][] f = new int[k + 1][n];
		for (int i = 0; i <= k; i++)
			f[i][0] = 1;
		for (int i = 0; i < n; i++)
			f[0][i] = i + 1;
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}
		return f[k][n - 1];
	}
}
