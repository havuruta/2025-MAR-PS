

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2579 {


    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1; i<=N; i++) {
            int n = Integer.parseInt(br.readLine());
            stairs[i] = n;
        }

        // 무적권 1부터니깐.
        dp[1] = stairs[1];
        
        // 2보다 크면 그냥 저장해서 쏘면 됨.
        if(N>=2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 3부터는 이제 연속으로 못 밟아서 뭐가 더 큰지 판단해야함..

        for(int i = 3; i<=N; i++) {
            // dp[i-2] 는 이전 계단은 건너뛰고 자기 밟은거임, dp[i-3] + stairs[i-1]은 이번 계단 전전전계단을 밟고, 전계단을 밟고, 이번계단 밟은거
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }
   

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}
