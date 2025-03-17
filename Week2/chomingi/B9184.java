package Week2.chomingi;

import java.util.*;
import java.io.*;

public class B9184 {
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 011 001 010 000
        int[][][] dp = new int[21][21][21];

        while (true) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c, dp));
            st = new StringTokenizer(br.readLine());
        }
    }

    static int w(int a, int b, int c, int[][][] dp) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20, dp);
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a,b,c-1,dp)+w(a,b-1,c-1,dp)-w(a,b-1,c,dp);
        }
        return dp[a][b][c]=w(a-1,b,c,dp)+w(a-1,b-1,c,dp)+w(a-1,b,c-1,dp)-w(a-1,b-1,c-1,dp);
    }
}
