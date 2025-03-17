package Week2.nayoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// B9184 신나는 함수 실행
// 문제 목표: 주어진 a, b, c에 대해 w(a, b, c) 값을 계산하는 함수
// 아이디어: 재귀를 활용하여 계산, 중복 계산을 막기 위해 memoization 기법을 사용
//메모리 42212kb
//시간 516ms
public class B9184 {
    static int a;
    static int b;
    static int c;
    static int[][][] memo;  // memoization을 위한 3차원 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 3D 배열 memo 초기화 (각 a, b, c는 0 ~ 20 범위)
        memo = new int[21][21][21];
        StringTokenizer st;

        // 계속해서 입력을 받으며 계산을 수행
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); // a 값
            b = Integer.parseInt(st.nextToken()); // b 값
            c = Integer.parseInt(st.nextToken()); // c 값

            // 종료 조건: a, b, c가 모두 -1일 때
            if (a == -1 && b == -1 && c == -1) {
                break;
            } else {
                // 계산 후 결과 출력
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + recur(a, b, c));
            }
        }

        // 리소스 해제
        bw.flush();
        bw.close();
        br.close();
    }

    // w(a, b, c) 값을 계산하는 재귀 함수
    static int recur(int a, int b, int c) {
        // 기저 사례: a, b, c 중 하나라도 0 이하인 경우
        if (a <= 0 || b <= 0 || c <= 0) return 1;
            // 기저 사례: a, b, c가 20을 초과하는 경우
        else if (a > 20 || b > 20 || c > 20) return recur(20, 20, 20);
            // 이미 계산된 값이 있는 경우 memoization을 활용하여 바로 반환
        else if (memo[a][b][c] >= 1) return memo[a][b][c];

            // a < b < c 일 때의 경우
        else if (a < b && b < c) {
            // 필요한 값을 먼저 계산하고 memo 배열에 저장
            memo[a][b][c - 1] = recur(a, b, c - 1);
            memo[a][b - 1][c - 1] = recur(a, b - 1, c - 1);
            memo[a][b - 1][c] = recur(a, b - 1, c);

            // 결과를 계산하여 memo 배열에 저장하고 반환
            return memo[a][b][c - 1] + memo[a][b - 1][c - 1] - memo[a][b - 1][c];
        }
        // a >= b >= c 일 때의 경우
        else {
            // 필요한 값을 먼저 계산하고 memo 배열에 저장
            memo[a - 1][b][c] = recur(a - 1, b, c);
            memo[a - 1][b - 1][c] = recur(a - 1, b - 1, c);
            memo[a - 1][b][c - 1] = recur(a - 1, b, c - 1);
            memo[a - 1][b - 1][c - 1] = recur(a - 1, b - 1, c - 1);

            // 결과를 계산하여 memo 배열에 저장하고 반환
            return memo[a - 1][b][c] + memo[a - 1][b - 1][c] + memo[a - 1][b][c - 1] - memo[a - 1][b - 1][c - 1];
        }
    }
}
