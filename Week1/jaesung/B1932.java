package jaesung;

/*
 문제 : 1932(정수 삼각형)
 시간 : 792ms
 풀이 : 삼각형 위에서부터 각 칸의 수를 더한 후 제일 아래 줄의 결과 중 최댓값을 출력.
 양 끝쪽 칸은 삼각형 위쪽 줄의 양 끝칸 누적합을 더하고,
 그외 칸은 삼각형 위쪽 줄에서 해당 칸에 접근 가능한 두 칸 중 최댓값의 누적합을 더하여 계산
 */

import java.io.IOException;
import java.util.Scanner;

public class B1932 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] tri = new int[n][n];
		
		for (int i = 0; i < tri.length; i++) {
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[n][n];
		
		dp[0][0] = tri[0][0];
		int ans = dp[0][0];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				// 가장 왼쪽 칸
				if (j == 0) dp[i][j] = dp[i-1][j] + tri[i][j];
				// 가장 오른쪽 칸
				else if (j == i) dp[i][j] = dp[i-1][j-1] + tri[i][j];
				// 그외 칸
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
				
				if (i == n-1) ans = Math.max(ans, dp[i][j]);
			}
		}
		
		System.out.println(ans);
	}
}
