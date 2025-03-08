package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//B2193 이친
public class B2193 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N자리 이친수
		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[91]; // 편의상 1좀 더할게요

		// 1자리는 1개

		dp[1] = 1;

		// N이 2이상인경우 2자리도 1
		if (N >= 2) {
			dp[2] = 1;
		}
		
		//dp로 값 구하기 종이에 노가다좀 했는데 보니까 피보나치던데
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
