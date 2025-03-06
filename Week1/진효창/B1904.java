package 진효창;

import java.util.Scanner;

public class B1904 {
	// 1904 - 01타일
	// 00과 1이 한쌍임 무한대로 n길이의 이진수 갯수를 구하기

	// 일단 조합을 해보면? 규칙이 있을듯?
	// 점화식도 가는길에 다 나누어주기 15746
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0]=1;
		dp [1] = 1;
		
		for(int i=2;i<n+1;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		}
		System.out.println(dp[n]);
		
		
	}
		// 1 -> 1
		// 11 00 -> 2
		// 111 100 001 -> 3
		// 1111 1100 1001 0011 0000 -> 5
		// 11111 11100 11001 10011 00111 00001 00100 10000 -> 8
		// 111111 111100 111001 110011 100111 001111 000011 001001 100001 100100 110000 001100 000000 -> 13
		// 피보나치;;
}