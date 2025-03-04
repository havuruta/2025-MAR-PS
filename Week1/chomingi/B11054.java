package chomingi;

import java.io.*;
import java.util.*;

public class B11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        // DP 두번돌리고 합치기
        // dp[i] : i번째 수를 마지막으로 하는 가장 긴 증가하는 부분 수열
        // dp2[i] : i번째 수를 시작으로 하는 가장 긴 증가하는 부분 수열
        // dp[i] + dp2[i] - 1 : i번째 수를 중심으로 하는 가장 긴 바이토닉 부분 수열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if (arr[j] < arr[i]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i] + dp2[i] - 1);
        }

        System.out.println(max);
    }
}
