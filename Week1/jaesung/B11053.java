package jaesung;

/*
 문제 : 11053(가장 긴 증가하는 부분 수열)
 시간 : 236ms
 풀이 : 현재 인덱스 이전까지의 부분 수열 중 가장 긴 증가하는 부분 수열 길이를 갱신하여 답을 구한다.
 */

import java.io.IOException;
import java.util.Scanner;

public class B11053 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 각 인덱스에서 가장 긴 증가하는 부분 수열 길이를 저장
		int[] dp = new int[N];
		// 초기값
		dp[0] = 1;
		
		int ans = dp[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			
			for (int j = i-1; j >= 0; j--) {
				// 현재 인덱스 값보다 작을 경우(=증가하는 부분 수열인 경우)
				// 가장 긴 증가하는 부분 수열 길이 갱신
				if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			
			// 최댓값 갱신
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
