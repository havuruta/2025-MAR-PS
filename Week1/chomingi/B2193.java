package chomingi;

import java.io.*;
import java.util.*;

public class B2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 직관적으로
        // 0으로 끝나는 경우와 1로 끝나는 경우로 나누어 생각
        // long[][] dp = new long[N+1][2];
        // dp[1][0] = 0;
        // dp[1][1] = 1;
        // for (int i = 2; i <= N; i++) {
        //     dp[i][0] = dp[i-1][0] + dp[i-1][1];
        //     dp[i][1] = dp[i-1][0];
        // }
        // System.out.println(dp[N][0] + dp[N][1]);

        // 간소화
        // 어차피 0으로 끝나는 경우는 1로 끝나는 경우의 합이므로
        // 0으로 끝나는 경우와 1로 끝나는 경우만 생각
        long[] dp = new long[N+1];
        dp[1] = 1;
        if (N > 1) dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
