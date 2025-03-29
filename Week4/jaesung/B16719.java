package Week2.problem;

/*
 문제 : 16719(ZOAC)
 시간 : 244ms
 풀이 : 사전순으로 가장 빠른 문자를 기준으로 오른쪽 부분 문자열과 왼쪽 부분 문자열에 대해 재귀함수를 수행.
 */

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class B16719 {
    static String str;
	static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		visit = new boolean[str.length()];
		func(0, str.length());

	}
	
	static void func(int left, int right) {
		if (left >= right) {
			return;
		}
		
		char target = 'Z'+1;
		int idx = 0;
		for (int i = left; i < right; i++) {
			if (target > str.charAt(i)) {
				target = str.charAt(i);
				idx = i;
			}
		}
		
		visit[idx] = true;
		
		for (int i = 0; i < visit.length; i++) {
			if (visit[i]) {
				System.out.print(str.charAt(i));
			}
		}
		
		System.out.println();
		
		func(idx + 1, right);
		func(left, idx);
	}
}