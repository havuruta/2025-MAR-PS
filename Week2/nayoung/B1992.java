package Week2.nayoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// B1992 쿼드트리
// 시간: 112ms
// 메모리: 15508kb
// 아이디어: 분할정복, 재귀 활용

public class B1992 {
    static char[][] arr; // 흑백 영상 배열
    static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
    static int N; // 영상의 크기 (N x N)

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 영상의 크기 입력 (2의 제곱수, 1 <= N <= 64)
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        // 배열 값 채우기
        for (int i = 0; i < N; i++) {
            String str = br.readLine().strip(); // 입력받은 문자열
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j); // 각 문자를 배열에 저장
            }
        }

        // 재귀적으로 쿼드트리 압축 수행
        recur(0, N - 1, 0, N - 1);

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 분할정복 방식으로 쿼드트리 압축하는 함수
    // rStart, rEnd: 행의 시작과 끝 인덱스
    // cStart, cEnd: 열의 시작과 끝 인덱스
    static void recur(int rStart, int rEnd, int cStart, int cEnd) {
        // 종료 조건: 배열 범위를 벗어난 경우
        if (rStart > rEnd || cStart > cEnd) return;

        int cnt = 0; // '1'의 개수 세기

        // 현재 영역에서 '1'의 개수를 셈
        for (int i = rStart; i <= rEnd; i++) {
            for (int j = cStart; j <= cEnd; j++) {
                if (arr[i][j] == '1') {
                    cnt++;
                }
            }
        }

        // 현재 영역이 모두 0으로 이루어져 있으면 '0'을 추가하고 종료
        if (cnt == 0) {
            sb.append(0);
            return;
        }

        // 현재 영역이 모두 1로 이루어져 있으면 '1'을 추가하고 종료
        else if (cnt == (rEnd - rStart + 1) * (cEnd - cStart + 1)) {
            sb.append(1);
            return;
        }

        // 현재 영역이 모두 동일하지 않다면 '('를 추가하고, 4개 영역으로 분할
        sb.append("(");

        // 왼쪽 위
        recur(rStart, (rStart + rEnd) / 2, cStart, (cStart + cEnd) / 2);
        // 오른쪽 위
        recur(rStart, (rStart + rEnd) / 2, (cStart + cEnd) / 2 + 1, cEnd);
        // 왼쪽 아래
        recur((rStart + rEnd) / 2 + 1, rEnd, cStart, (cStart + cEnd) / 2);
        // 오른쪽 아래
        recur((rStart + rEnd) / 2 + 1, rEnd, (cStart + cEnd) / 2 + 1, cEnd);

        // ')'를 추가하여 현재 구역을 종료
        sb.append(")");
    }
}
