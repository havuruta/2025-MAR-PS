// 문제: 1932 정수 삼각형
// 설명: 정수 삼각형에서 최대 합을 구하는 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(i == 0 && j == 0) dp[i][j] = num;
				else if(j == 0) {
					dp[i][j] = num + dp[i - 1][j];
				} else if(j == i) {
					dp[i][j] = num + dp[i - 1][j - 1];
				} else {
					dp[i][j] = num + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		bw.write(String.valueOf(max));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
