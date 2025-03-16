package jaesung;

/*
 문제 : 1992(쿼드트리)
 시간 : 108ms
 풀이 : 분할정복을 수행하여 각 사분면에 대해 값이 동일한지 여부에 따라 구성된 문자열을 통합 후 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1992 {
static StringBuilder answer = new StringBuilder();
	static int[][] display;
	
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		display = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			char[] tmp = st.nextToken().toCharArray();
			
			for (int j = 0; j < N; j++) 
				display[i][j] = (tmp[j] - '0');
		}
		
		System.out.println(compression(N, 0, 0));
	}
	
	// 압축 수행 재귀함수
	static String compression(int n, int row, int col) {
		// 사이즈가 1인 경우 해당 좌표 값을 반환
		if (n == 1) return Integer.toString(display[row][col]);
		
		// 각 사분면 결과 저장 배열
		String[] results = new String[4];
		
		// 절반으로 나눠서 각 사분면에 대해 분할 정복 수행
		int half = n / 2;
		results[0] = compression(half, row, col);
		results[1] = compression(half, row, col + half);
		results[2] = compression(half, row + half, col);
		results[3] = compression(half, row + half, col + half);
		
		// 모든 사분면 결과가 단일 값으로 압축되어 있는지 판단
		boolean isQuadSame = true;
		String thr = results[0]; // 기준값
		
		for (int i = 0; i < results.length; i++) {
			// 해당 사분면 결과가 0 혹은 1이 아닌지 
			if (!results[i].equals("0") && !results[i].equals("1")) {
				isQuadSame = false;
				break;
			}
			
			// 해당 사분면 값이 기준값과 똑같은지
			if (!results[i].equals(thr)) {
				isQuadSame = false;
				break;
			}
		}
		
		// 각 사분면 압축결과를 표현
		if (!isQuadSame) {
			StringBuilder result = new StringBuilder();
			
			result.append("(");
			
			for (int i = 0; i < results.length; i++)
				result.append(results[i]);
			
			result.append(")");
						
			thr = result.toString();
		}
		
		// 결과 반환
		return thr;
	}
}
