package chomingi;

import java.io.*;
import java.util.*;

public class B2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for (int i = 0; i < 15; i++) dp[0][i] = i;
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // i층 j호에 사는 사람 수 = i-1층 j호 사는 사람수 + i층 j-1호 사는 사람(i-1층 1호부터 j-1호까지 사는 사람 수)
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            System.out.println(dp[k][n]);
        }
    }
}
