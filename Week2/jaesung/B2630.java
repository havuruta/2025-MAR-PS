package jaesung;

/*
 문제 : 2630(색종이 만들기)
 시간 : 140ms
 풀이 : 분할 정복으로 단일 색상인 경우를 판별하고 그에 따라 색종이 개수를 카운트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {
    static int white;
	static int blue;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {			
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) 
				paper[i][j] = Integer.parseInt(tmp[j]);
		}
		
		white = 0;
		blue = 0;
		
		// 전체 색종이가 단일 색상인 경우 계산
		int totalColor = countPaper(N, 0, 0);
		if (totalColor == 0) ++white;
		else if (totalColor == 1) ++blue;
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static int countPaper(int n, int row, int col) {
		// 사이즈가 1인 경우 해당 좌표 값을 반환
		if (n == 1) return paper[row][col];
		
		// 각 사분면 결과 저장 배열
		int[] results = new int[4];
		
		// 절반으로 나눠서 각 사분면에 대해 분할 정복 수행
		int half = n / 2;
		results[0] = countPaper(half, row, col);
		results[1] = countPaper(half, row, col + half);
		results[2] = countPaper(half, row + half, col);
		results[3] = countPaper(half, row + half, col + half);
		
		// 모든 사분면 결과가 같은 색상인지 판단
		boolean isColorSame = true;
		int thr = results[0]; // 기준값
		
		for (int i = 0; i < results.length; i++) {
			// 해당 사분면 결과가 0 혹은 1이 아닌지 
			if (results[i] == -1) {
				isColorSame = false;
				break;
			}
			
			// 해당 사분면 값이 기준값과 똑같은지
			if (results[i] != thr) {
				isColorSame = false;
				break;
			}
		}
		
		// 각 사분면 값 동일 여부에 따라 색상 카운트
		if (!isColorSame) {
			for (int i = 0; i < results.length; i++) {
				if (results[i] == -1) continue;
				
				if (results[i] == 1) ++blue;
				else ++white;
			}
			
			return -1;
		}
		
		// 결과 반환
		return thr;
	}
}
