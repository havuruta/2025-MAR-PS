package jaesung;

/*
 문제 : 9184(신나는 함수 실행)
 시간 : 372ms
 풀이 : 입력 인덱스에 대한 재귀 함수 호출 결과를 출력.
 3차원 배열에 각 재귀함수 호출 결과를 저장하고 해당 인덱스를 체크하여, 다음 재귀 함수 실행 과정에서 해당 인덱스 접근 시 저장된 값을 반환.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B9184 {
    // 호출 결과 값 저장 배열
	static int[][][] arr;
	// 저장 체크 배열
	static boolean[][][] check;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[101][101][101];
		check = new boolean[101][101][101];
		
		while (true) {
			StringBuilder sb = new StringBuilder(); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1 && c == -1) break;
						
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
			bw.write(sb.toString());
			
			st = new StringTokenizer(br.readLine());
		}
		
		bw.flush();
		bw.close();
	}
	
	static int w(int a, int b, int c) {
		// 이미 저장된 인덱스일 경우 해당 값 반환
		if (check[a+50][b+50][c+50]) return arr[a+50][b+50][c+50];
		
		
		// 각 조건에 해당하는 값 저장 및 체크 후 값 반환
		if (a <= 0 || b <= 0 || c <= 0) {
			int val = 1;
			arr[a+50][b+50][c+50] = val;
			check[a+50][b+50][c+50] = true;
			return val;
		}
		
		if (a > 20 || b > 20 || c > 20) {
			int val = w(20, 20, 20);
			arr[a+50][b+50][c+50] = val;
			check[a+50][b+50][c+50] = true;
			
			return val;
		}
		
		if (a < b && b < c) {
			int val = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			arr[a+50][b+50][c+50] = val;
			check[a+50][b+50][c+50] = true;
			
			return val;
		}
		
		int val = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		arr[a+50][b+50][c+50] = val;
		check[a+50][b+50][c+50] = true;
		
		return val;
	}
}
