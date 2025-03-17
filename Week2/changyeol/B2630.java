/*
 문제 : 2630(색종이 만들기)
 시간 : 136ms
 풀이 : 2차원 배열의 범위를 줄여가면서 같은 색만 있는지 판별 후, 흰색과 파란색 종이 카운트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2360 {
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}//end of main
	
	static void divide(int x, int y, int size) {
		//기저 조건
		if(isSameColor(x, y, size)) {
			if(arr[x][y] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		//재귀 부분
		//영역 4등분
		int nextSize = size / 2;
		divide(x, y, nextSize);
		divide(x, y + nextSize, nextSize);
		divide(x + nextSize, y, nextSize);
		divide(x + nextSize, y + nextSize, nextSize);
	}

	static boolean isSameColor(int x, int y, int size) {
		int color = arr[x][y];
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if (arr[i][j] != color) {
					return false; // 색이 다르면 false
				}
			}
	    }
		return true;
	}
}//end of class
