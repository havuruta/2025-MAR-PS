// 문제: 24416 알고리즘 수업 - 피보나치 수 1
// 설명: 피보나치 수를 재귀와 동적 프로그래밍으로 구현하여 코드 실행 횟수 비교

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B24416  {
	static int[] f;	
	static int code1Cnt, code2Cnt; //  코드 1, 2의 실행 횟수 저장 변수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		bw.write(code1Cnt + " " + code2Cnt);
		br.close();
		bw.flush();
		bw.close();
	}
	// 피보나치 수 재귀 호출
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			code1Cnt++;
			return 1;
		}
		return (fib(n - 1) + fib(n - 2));
	}
	// 피보나치 수 동적 프로그래밍
	public static int fibonacci(int n) {
		f = new int[n];
		f[0] = f[1] = 1;
		for(int i = 2; i < n; i++) {
			code2Cnt++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1];
	}
}
