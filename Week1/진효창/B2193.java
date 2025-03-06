package 진효창;

import java.util.Scanner;

public class B2193 {
	// 2193 - 이친수
	// n길이의 이친수의 갯수를 찾음

	// 11이 붙은 경우 제외 0으로 시작 제외

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] dp = new long[91];

		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 1;
		}

		for (int i = 3; i < n+1; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);

	}

	// 1-> 1 <1개>
	// 2-> 10<1개>
	// 3-> 100 101<2개>
	// 4-> 1010 1001 1000 <3개>
	// 5-> 10000 10001 10010 10100 10101 <5개>
	// 6-> 100000 100001 100010 100100 100101 101010 101001 1010000 <8개>
}