package 진효창;

import java.util.Scanner;

public class B24416 {
    //24416 - 알고리즘 수업 - 피보나치 수1
    //문제에 적혀있는 형태의 재귀 메서드와 dp 메서드를 만들어 각각의 실행횟수를 출력

	static int n;
	static int recurcnt = 0;//재귀 반복 횟수
	static int dpcnt = 0;//dp 반복횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		fibo(n);//재귀
		fibona(n);//DP

		System.out.println(recurcnt + " " + dpcnt);

	}

	private static int fibo(int cur) {
		if (cur == 1 || cur == 2) {
			recurcnt++;
			return 1;
		}
		return fibo(cur - 1) + fibo(cur - 2);
	}

	private static int fibona(int cur) {
		if (cur == 1 || cur == 0) {
			return cur;
		}
		int[] dp = new int[cur + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i < cur + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dpcnt++;
		}
		return dp[cur];
	}
}