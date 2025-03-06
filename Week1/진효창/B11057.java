package 진효창;

import java.util.Scanner;

public class B11057 {
	// 11057 - 오르막 수
	// 수를 한자리씩 끊어봐서 오름차순인 경우 카운트

	// n개 자리니까 n개 배열을 만듬? | 아님
	// 1~9까지 넣으면서 가능한 수를 찾아야하나 | 아님
	// 뒤에서부터 수를 정하고 가짓수를 줄여나가는게 좋을듯? | ?
	// 가짓수는 배열의 값을 곱하면 되는거니까? | ?
	// arr[0]은 1~9(9가지) 나머지는 0~9(10가지) | ?
	// 하고 10007로 나눔 | 계속 나눠야햇음
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);



		int n = sc.nextInt();
		int[] dp = new int[10];// 0-9까지 가질 수 있는 경우의 수를 담은 배열
		for (int i = 0; i < n; i++) {
			int[] temp = new int[10];
			temp[0] = 1;
			for (int j = 1; j < 10; j++) {
				temp[j] = (temp[j - 1] + dp[j])%10007;
			}
			dp = temp;
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans =(ans+ dp[i])%10007;
		}
		System.out.println(ans);
	}
    	// ㅋㅋ

		// 1 1 1 1 1 1 1 1 1 1 -> 10
		// 1 2 3 4 5 6 7 8 9 10 -> 55
		// 1 3 6 10 15 21 28 36 45 55 -> 220
}