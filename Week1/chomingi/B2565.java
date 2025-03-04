package chomingi;

import java.io.*;
import java.util.*;

public class B2565 {
    static int MAX_SIZE = 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // LIS 처럼 풀기
        // 1. A전봇대를 기준으로 오름차순 정렬
        // 2. B전봇대를 기준으로 LIS를 구한다.
        int[][] wire = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, (a, b) -> a[0] - b[0]);
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wire[i][1] > wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
        
        
        
        
        // LIS 처럼 풀기 + 포인터 이용(상태관리)
        // int[] wire = new int[MAX_SIZE];
        
        // for (int i = 0; i < N; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     wire[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        // }
        // int[] dp = new int[MAX_SIZE];
        // int end = 0;
        // for (int i = 0; i<MAX_SIZE; i++){
        //     if (wire[i]==0) continue;
        //     int start = 0;
        //     while (start<=end && wire[i]>dp[start]) start++;
        //     if (start>end) end++;
        //     dp[start] = wire[i];
        // }

        // System.out.println(N-end);
    }
}
