package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//B2579 계단오르기
public class B2579 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //계단의 개수
		
		int[] numbers = new int[N+1]; //각 계단에 써있는 수
		
		// 입력받기
		for(int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		//dp배열 각 계단에서 최댓값
		int[] dp = new int[N+1]; //
		
		// 첫칸은 첫칸 값
		dp[1] = numbers[1];
		
		//2칸이상일 경우 2번째 계단의 값은 1+2값
		if(N >= 2) {
			dp[2] = numbers[1] + numbers[2];
		}
		
		//dp -> 2칸전에서 바로 오는 값 vs 3칸전에서 1칸전으로 온 값중 더 큰값에 현재 위치 값 더하기
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + numbers[i-1]) + numbers[i];			
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}

