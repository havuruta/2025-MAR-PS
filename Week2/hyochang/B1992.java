package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B1992 {
    // 1992 - 쿼드 트리
    // 4분할하고 모두 같으면 그 숫자로 압축이 가능

    // 분할하고 다 같으면 해당숫자로 압축
    // 아닌 경우에는 괄호를 추가

    static boolean[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        video = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                if (temp.charAt(j) == '1') {
                    video[i][j] = true;
                }
            }
        }
        zip(0, 0, n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void zip(int i, int j, int n) {
        // TODO Auto-generated method stub

        if (completed(i, j, n)) {
            if (video[i][j]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }
        int half = n / 2;

        sb.append("(");
        zip(i, j, half);
        zip(i, j + half, half);
        zip(i + half, j, half);
        zip(i + half, j + half, half);
        sb.append(")");
    }

    private static boolean completed(int i, int j, int n) {//해당 구역 확인하는 메서드
        // TODO Auto-generated method stub
        boolean start = video[i][j];
        for (int y = i; y < i + n; y++) {
            for (int x = j; x < j + n; x++) {
                if (video[y][x] != start)
                    return false;
            }
        }
        return true;
    }
}
