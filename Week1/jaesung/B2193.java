package jaesung;

/*
 문제 : 2193(이친수)
 시간 : 176ms
 풀이 : N자리 이친수의 개수는 아래 식과 같은 규칙을 가지므로 이를 활용해 개수를 구한다.
 이친수 N자리 이친수 개수 = N-1자리 이친수 개수 + N-2 이친수 개수
 */

import java.io.IOException;
import java.util.Scanner;

public class B2193 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 입력 범위만큼 배열 사용
		long[] dp = new long[91];
		
		// 초기값
		dp[1] = 1;
		dp[2] = 1;
		
		// 규칙에 맞게 계산 및 저장
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[N]);
	}
}
