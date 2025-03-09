// 문제: 2193 이친수
// 설명: 특정 조건을 만족하는 이진수를 구하는 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 이친수
 * 1. 0으로 시작하지 않음
 * 2. 1이 두 번 연속으로 나타나지 않음. 즉, 11을 부분 문자열로 갖지 않음.
 * -> 피보나치 수열이잖아 ?
 */

public class B2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(fibonacci(N)));
		
		br.close();
		bw.flush();
		bw.close();
	}
	public static long fibonacci(int n) {
		/* long[] f = new long[n]; 
		 * -> n == 1 일 때 long[] f = new long[1]; 
		 * -> f[0] = f[1] = 1; 에서 에러 발생
		 * 해결법 1. long[] f = new long[n + 1];
		 * 해결법 2. n == 1 일 때 예외 처리 -> if(n == 1) return 1;
		 */ 
		long[] f = new long[n + 1]; // n의 범위가 90까지라서 long 타입 선언
		f[0] = f[1] = 1;
		for(int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1];
	}
}
