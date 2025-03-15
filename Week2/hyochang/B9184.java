package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B9184 {
    // 9184 - 신나는 함수 발생
    // 재귀함수를 보고 해당 값을 출력하는 코드 작성

    // 하나라도 0이나 음수이면 1반환
    // 하나라도 20보다 크면 w(20,20,20)
    // a<b<c이면 w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
    // 가 아니면 w(a-1,b,c)+w(a-1,b,c-1)+w(a-1,b,c-1)-w(a-1,b-1,c-1)반환

    // 재귀함수 규칙이 뭔지 알아내고 계산?
    // DP없이는 시간 초과 발생
    // 태그를 안보고 DP(메모이제이션)을 떠올리기 어려울 듯?
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new int[50][50][50];
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int ans = w(a, b, c);
            System.out.println(String.format(("w(%d, %d, %d) = %d"), a, b, c, ans));
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (dp[a][b][c] != 0) {// 이미 값이 있다면 반환
            return dp[a][b][c];
        }
        if (a < b && b < c) {// 필요한 연산을 진행
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return dp[a][b][c];
    }
}