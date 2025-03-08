package jaesung;

/*
 문제 : 2775(부녀회장이 될테야)
 시간 : 172ms
 풀이 : 입력범위만큼의 2차원 배열에 k층 n호 값을 미리 저장하고, 입력에 대한 값을 출력한다.
 0층은 초기값으로 지정하여 각 호 만큼의 값을 저장하고,
 이외의 값은 현재층(k)에서 이전 호의(n-1) 값 + 이전층(k-1)에서 현재 호(n)의 값을 더하여 저장한다.
 */

import java.io.IOException;
import java.util.Scanner;

public class B2775 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int[][] apt = new int[15][15];
		
		
		for (int i = 0; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				if (i == 0) apt[i][j] = j;
				else apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(apt[k][n]);
		}
	}
}
