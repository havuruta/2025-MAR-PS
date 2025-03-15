package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B2447 {
    // 2447 - 별찍기
    // 패턴에 맞추어 출력

    // 배열 만들고 규칙으로 찍음
    static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        star = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = '*';
            }
        }
        staring(0, 0, n);
        for (int i = 0; i < n; i++) {//stringbuilder가 없으면 시간초과 발생
            for (char s : star[i]) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void staring(int starty, int startx, int range) {//시작점, 한변의 길이
        int section = range / 3;
        if (section == 0) {
            return;
        }
        for (int y = starty + section; y < starty + 2 * section; y++) {
            for (int x = startx + section; x < startx + 2 * section; x++) {
                star[y][x] = ' ';
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)//가운데 공백처리니까 제외
                    continue;
                staring(starty + i * section, startx + j * section, section);//8개 모두 호출
            }
        }
    }
}
