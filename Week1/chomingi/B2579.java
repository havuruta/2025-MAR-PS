package chomingi;

import java.io.*;
import java.util.*;

public class B2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][2];
        int[] stairs = new int[N+1];

        for (int i = 1; i <= N; i++) stairs[i] = Integer.parseInt(br.readLine());

        //dp[i][0] : 연속되지 않은 선택
        //dp[i][1] : 연속된 선택(i-1 또한 선택된 경우)
        //따라서 dp[i][1] 일때 dp[i-1][0]을 가져와야 3연속 선택을 방지할 수 있다.
        
        //dp[i][0] = max(dp[i-2][0], dp[i-2][1]) + stairs[i]
        //dp[i][1] = dp[i-1][0] + stairs[i]
        dp[1][0] = stairs[1];
        dp[1][1] = stairs[1];
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
            dp[i][1] = dp[i-1][0] + stairs[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
