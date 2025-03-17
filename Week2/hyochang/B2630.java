package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B2630 {
    // 2630 - 색종이
    // 4분의 1로 나눔 나누었을 때 모두 같은 색이면 분해 x 흰 종이 파랑 종이 갯수

    // 계속 나눠서 판별 분할정복(재귀)
    // 나누면서 나눈 것의 색을 탐색 아니면 나누어서 다시 진행
    static boolean[][] paper;
    static int blue;
    static int white;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new boolean[n][n];
        blue = 0;
        white = 0;

        // 1은 파랑(true) 0은 하양(false)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    paper[i][j] = true;
                }
            }
        }
        divide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }

    private static void divide(int i, int j, int range) {// i,j는 시작점
        // range는 내가 탐색할 범위
        if (check(i, j, range)) {// 탐색하는 메서드 똑같은 매개변수
            if (paper[i][j])
                blue++;
            else
                white++;
            return;
        }
        // 종료가 안되면 남은애들은 분할 후 다시
        divide(i, j, range / 2);
        divide(i + range / 2, j, range / 2);
        divide(i, j + range / 2, range / 2);
        divide(i + range / 2, j + range / 2, range / 2);
    }

    private static boolean check(int i, int j, int range) {//해당 구역 확인하는 메서드
        // TODO Auto-generated method stub
        boolean start = paper[i][j];
        Loop: for (int y = i; y < i + range; y++) {
            for (int x = j; x < j + range; x++) {
                if (start != paper[y][x]) {
                    return false;
                }
            }
        }
        // 끝까지 탐색하면 true 반환
        return true;
    }

}