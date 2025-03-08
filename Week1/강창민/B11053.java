package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// B11053 가장 긴 증가하는 부분 수열

/*
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 */
public class B11053 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//수열의 크기
		int N = Integer.parseInt(br.readLine());
		
		//수열 숫자저장
		int[] numbers = new int[N];
		
		//기본적으로 1임
		int maxCount = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		//  dp[i]: i번째 요소를 마지막 원소로 하는 LIS(최장 증가 부분 수열)의 길이
		int[] dp = new int[N];
		
		//기본값 1저장
		Arrays.fill(dp, 1);
		
		//i번째 자리
		for(int i = 1; i < N; i++) {
			
			//i번째 자리전까지 비교
			for(int j = 0; j < i; j++) {
				//i번째가 그 전보다 큰경우 i값과 j자리 +1 중 더 큰값임
				if(numbers[i] > numbers[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			//최대값 저장
			maxCount = Math.max(dp[i], maxCount);
		}
		
		
		bw.write(maxCount + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

