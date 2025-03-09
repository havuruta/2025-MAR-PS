// 문제: 11053 가장 긴 증가하는 부분 수열(LIS)
// 설명: 수열에서 가장 긴 증가하는 부분 수열을 찾는 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine()); // 수열 A의 크기

		int[] A = new int[L]; // 수열 A 저장할 배열
		int[] dp = new int[L]; // 가장 긴 증가하는 부분 수열의 길이를 저장할 배열
		
		// dp 배열을 1로 초기화
		for (int i = 0; i < L; i++) {
			dp[i] = 1;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < L; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			// 첫번째 숫자인 경우, 비교할 이전 숫자가 없으니까 continue
			if (i == 0) continue;
			// 이전의 숫자들을 돌면서 비교
			for (int j = 0; j < i; j++) {
				// 만약 이전 숫자보다 현재가 클 경우
				if (A[i] > A[j]) {
					// 이전 숫자의 + 1 한 값과 현재 값 중 최대값을 저장
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 최대 길이 찾기
		int max = Integer.MIN_VALUE;
		for(int i=0; i<L; i++) {
			max = Math.max(max, dp[i]);
		}
		
		bw.write(String.valueOf(max));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
