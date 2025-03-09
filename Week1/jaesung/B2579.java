package jaesung;

/*
 문제 : 2579(계단 오르기)
 시간 : 180ms
 풀이 : 각 인덱스의 계단을 밟았을 때, 이전에 밟은 계단이 두칸 전인지 한칸 전인지에 따라 값을 저장
 이후 최종 지점에서 두 경우 중 최댓값을 출력
 */

import java.io.IOException;
import java.util.Scanner;

public class B2579 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][2];
		
		// 초기값
		dp[1][0] = arr[1];
		dp[1][1] = 0;
		
		// 현재 인덱스 계단을 밟았을 때, 이전의 계단이 두칸 전인지 한칸 전인지에 따라 각각 0, 1 인덱스에 저장
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.max(dp[i-2][0] + arr[i], dp[i-2][1] + arr[i]);
			dp[i][1] = dp[i-1][0] + arr[i];
		}
		
		// 도착계단에서의 최댓값 출력
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}
