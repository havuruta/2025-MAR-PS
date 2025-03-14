package Week2.nayoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// B2630 색종이 만들기
// 문제 목표: 주어진 N x N 색종이에서 색깔이 같은 부분으로 나누어 각각의 색깔 개수를 세는 문제
// 아이디어: 분할 정복(재귀)을 활용하여 색종이를 나누고 색깔을 세기
//메모리 18108kb
//시간 176ms
public class B2630 {
    static int[][] arr; // 색종이 배열
    static int white = 0; // 흰색 색종이 개수
    static int blue = 0;  // 파란색 색종이 개수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N: 전체 종이의 크기 (2, 4, 8, 16, 32, 64, 128 중 하나)
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;

        // 배열 값 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 재귀 호출로 색종이의 색깔 개수 계산
        recur(0, N - 1, 0, N - 1);

        // 결과 출력
        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    // 분할 정복을 활용한 재귀 함수
    // rStart, rEnd: 행의 시작과 끝 인덱스
    // cStart, cEnd: 열의 시작과 끝 인덱스
    static void recur(int rStart, int rEnd, int cStart, int cEnd) {
        // 종료 조건: 영역의 시작 인덱스가 끝 인덱스를 넘어가면 종료
        if (rStart > rEnd || cStart > cEnd) return;

        int cnt = 0; // 파란색 개수

        // 현재 영역에서 파란색(1)의 개수 세기
        for (int i = rStart; i <= rEnd; i++) {
            for (int j = cStart; j <= cEnd; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }

        // 만약 파란색이 하나도 없으면 흰색으로 결정
        if (cnt == 0) {
            white++;  // 흰색 색종이
            return;
        }
        // 만약 파란색이 전체 영역을 차지하면 파란색으로 결정
        else if (cnt == (rEnd - rStart + 1) * (cEnd - cStart + 1)) {
            blue++;   // 파란색 색종이
            return;
        }

        // 그 외의 경우, 영역을 4등분하여 재귀적으로 나눠서 색깔 세기
        int midRow = (rStart + rEnd) / 2;
        int midCol = (cStart + cEnd) / 2;

        // 4개의 구역에 대해 각각 재귀 호출
        recur(rStart, midRow, cStart, midCol);  // 왼쪽 위
        recur(rStart, midRow, midCol + 1, cEnd);  // 오른쪽 위
        recur(midRow + 1, rEnd, cStart, midCol);  // 왼쪽 아래
        recur(midRow + 1, rEnd, midCol + 1, cEnd);  // 오른쪽 아래
    }
}
