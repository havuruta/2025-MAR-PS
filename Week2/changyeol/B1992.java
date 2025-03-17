/*
 문제 : 1992(쿼드트리)
 시간 : 104ms
 풀이 : 2차원 배열의 범위를 줄여가면서 같은 숫자만 있는지 판별 후, 압축 결과 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1992 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';			
			}
		}
		
		compress(0, 0, N);
		
		System.out.println(sb);
		
	}//end of main

	private static void compress(int x, int y, int size) {
		//기저 조건
		if(isSameNum(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}
		
		sb.append("(");
		
		//재귀 부분
		//영역 4등분
		int nextSize = size / 2;
		compress(x, y, nextSize);
		compress(x, y + nextSize, nextSize);
		compress(x + nextSize, y, nextSize);
		compress(x + nextSize, y + nextSize, nextSize);
		
		sb.append(")");
	}

	private static boolean isSameNum(int x, int y, int size) {
		int num = arr[x][y];
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}//end of class
