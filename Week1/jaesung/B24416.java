package jaesung;

/*
 문제 : 24416 (알고리즘 수업 - 피보나치 수 1)
 시간 : 564ms
 풀이 : 재귀호출, 동적 프로그래밍 함수에서 해당 코드 호출 시 카운팅하여 호출 횟수 출력.
 */

import java.io.IOException;
import java.util.Scanner;

public class B24416 {
	static int n;
	static int fiboDpCount;
	static int fiboRecurCount;
	static int[] f;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		fiboDpCount = 0;
		fiboRecurCount = 0;
		
		n = sc.nextInt();
		
		f = new int[41];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(fiboRecurCount + " " + fiboDpCount);
	}
	
	// 재귀 호출
	static int fib(int n) {
		if (n == 1 || n == 2) {
			++fiboRecurCount;
			
			return 1;
		}
		
		return (fib(n-1) + fib(n-2));
	}
	
	// 동적 프로그래밍(Dp)
	static int fibonacci(int n) {
		f[1] = 1;
		f[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
			++fiboDpCount;
		}
		
		return f[n];
	}
}