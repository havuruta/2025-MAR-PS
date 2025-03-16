package jaesung;

/*
 문제 : 4779(칸토어 집합)
 시간 : 332ms
 풀이 : 입력 크기를 3등분하고 각 3등분 범위에 대해 재귀/공백출력/재귀 를 수행.
 */

import java.util.Scanner;


public class B2263 {
    static int N;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String str = sc.nextLine();
			
			if (str.isEmpty()) break;
			
			N = Integer.parseInt(str);
			sb = new StringBuilder();
			
			// 전체 사이즈
			int size = (int)Math.pow(3, N);
			
			func(size, 0, 0);
			
			System.out.println(sb);
		}
	}
	
	// 재귀함수
	static void func(int size, int st, int en) {
		// 선의 길이가 1
		if (size == 1) {
			sb.append("-");
			return;
		}
		
		size /= 3;
		
		// 3등분 범위에 대해 재귀-공백-재귀 수행
		func(size, st, size-1);
		for (int i = size; i < size*2; i++) {
			sb.append(" ");
		}
		func(size, size*2, en);
	}
}