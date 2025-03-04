package chomingi;

import java.io.*;
import java.util.*;

public class B11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // dp[i][j] : i번째 수를 j로 끝나는 오르막 수의 개수
        int[][] dp = new int[N+1][10];
        int mod = 10007;
        
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= mod;
        }

        System.out.println(sum);
    }
}
