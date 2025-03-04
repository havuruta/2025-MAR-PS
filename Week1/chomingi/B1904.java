package chomingi;

import java.io.*;
import java.util.*;

public class B1904 {
    static int MAX_SIZE = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX_SIZE + 1];
        dp[1] = 1;
        dp[2] = 2;

        // dp[i] = dp[i - 1] + dp[i - 2]
        // 뒤에 00을 붙이는 경우와 1을 붙이는 경우
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}
