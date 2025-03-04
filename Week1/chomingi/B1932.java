package chomingi;

import java.io.*;
import java.util.*;

public class B1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //top to bottom
        
        //N == 1일 때 예외처리 필요
        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0]+triangle[1][0];
        dp[1][1] = dp[0][0]+triangle[1][1];
        for (int i = 2; i<N; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for (int j = 1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        int max = 0;
        for (int i = 0; i<N; i++) max = Math.max(max, dp[N-1][i]);
        System.out.println(max);

        //bottom to top
        // for (int i = 0; i<N; i++) dp[N-1][i] = triangle[N-1][i];

        // for (int i = N-2; i>=0; i--){
        //     for (int j = 0; j<=i; j++){
        //         dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
        //     }
        // }
        // System.out.println(dp[0][0]);

    }
}
