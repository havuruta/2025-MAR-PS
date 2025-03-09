package 진효창;

import java.util.Scanner;

public class B11053 {
    //11053 - 가장 긴 증가하는 부분 수열
    //수열이 주어졋을 때 오름차순을 유지하는 부분 수열들 중 길이의 최댓값


    //DP? 재귀로하는거아님?
    //재귀는 시간초과;

    //DP로 
    //배열을 돌며 길이를 저장?함
    //DP라는 이름의 배열을 n으로 해서 생성
    //길이는 현재 수보다 탐색값이 작으면 증가
    //누적합처럼 현재 내가 배열에서 고른 값이 탐색한 값보다 크다면 기존 dp에 적혀있는 값을 사용
    //순회하며 현재값i보다 작은 탐색값j를 찾은 경우 dp[i] = dp[j]+1로 처리
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		// dp 배열에는 arr[i]가 가질 수 있는 가질 수 있는 배열의 길이(하나짜리가 가능하니 1처리)
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}

		// 부분 수열 뽑음
		// i는1부터 시작해서
		// j는 0부터 i까지

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {//현재 고른 수보다 작으면 +1을 함
					dp[i] = Math.max(dp[i], dp[j] + 1);//dp[j]는 arr[j]보다 작은 애들의 값임
				}
			}

		}
		int max = 0;
		for (int i = 0; i < n; i++) {//배열에서 최댓값이 최고 길이
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}