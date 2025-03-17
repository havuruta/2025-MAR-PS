/*
 문제 : 9184(신나는 함수 실행)
 시간 : 244ms
 풀이 : DP는 처음 보는거라 다른 코드 참고했습니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9184 {
    static int[][][] dp = new int[21][21][21]; // 3차원 DP 배열 (a, b, c의 최대값 20)
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            // 종료 조건
            if (a == -1 && b == -1 && c == -1) break;
            
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
              .append(") = ").append(w(a, b, c)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        
        // 이미 계산된 값이면 그대로 반환
        if (dp[a][b][c] != 0) return dp[a][b][c];
        
        // 메모이제이션
        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        
        return dp[a][b][c];
    }
}
