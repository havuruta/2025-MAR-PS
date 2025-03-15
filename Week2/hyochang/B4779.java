package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B4779 {
    // 4779 - 칸토어 집합
    // 3등분으로 나누고 가운데를 공백으로 1이 되면 종료

    // 가운데 없애고 나머지 2개에 대한 재귀
    // 입력 받으면 3^n 개 라 생각하고 가운데 구간 삭제?
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            n = sc.nextInt();
            int k = (int) Math.pow(3, n);
            sb = new StringBuilder("-".repeat(k));
            divide(0, k);
            System.out.println(sb);
        }
    }

    static void divide(int start, int end) {
        int section = (end - start) / 3;
        if (section == 0) {
            return;
        }
        sb.replace(start + section, start + section * 2, " ".repeat(section));

        divide(start, start + section);
        divide(end - section, end);
    }
}