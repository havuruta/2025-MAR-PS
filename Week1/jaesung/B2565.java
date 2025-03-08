package jaesung;

/*
 문제 : 11057(오르막 수)
 시간 : 172ms
 풀이 : 이전 자릿수 에서 가장 큰 자릿수(N=1일 경우 일의 자리, N=2일 경우 십의 자리)가 9~0일 때의 오르막 수의 개수를 누적하여 값을 2차원 배열에 저장.
 최종 결과는 배열에서 N행의 값을 모두 더하여 도출.
 
 ※ 기존 풀이는 이전 자릿수의 개수로부터 값을 빼서 계산을 수행.
 해당 풀이 링크 : https://github.com/gulddaggi/Java_Solved_Archive/blob/1569aa0c70618768295f2c3efd0c122089a10f9f/problem/src/problem/Problem.java
 */

import java.io.IOException;
import java.util.Scanner;

public class B2565 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
        int MOD = 10007;  // 모듈러 값 상수로 정의
		
		int[][] dp = new int[N+1][10];
		
		// 초기값
		for (int i = 0; i < 10; i++) dp[1][i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
				}
			}
		}
		
		// N행의 모든 값을 더하면 최종 결과
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = (ans + dp[N][i]) % MOD;
		}
		
		System.out.println(ans);
	}
}
