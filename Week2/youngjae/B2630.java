

import java.util.Scanner;

public class B2630 {
	static int N;
	static int [][] arr;
	static int white; // 하얀색 개수 0
	static int blue; //파란색 개수 1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}// 입력값 받기
		// 0이 흰색 1이 파란색
		fill(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	// 계속 잘라나가며 부분을 확인
	
	static void fill(int x, int y, int size) {
		// 기저조건(안에가 모두 같은 것 혹은 분리한 놈이 그 자신 그대로)
		if (visited(x,y,size)) {
			if (arr[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		int slice = size/2;
		fill(x,y,slice); // 좌상
		fill(x+slice, y, slice); // 좌하
		fill(x,y+slice, slice); // 우상
		fill(x+slice, y+slice, slice); // 우하
		
		
	}
	
	// 이게 current랑 비교햇을 때 size만큼의 박스가 다 같은 놈들인지
	static boolean visited(int x, int y, int size) {
		int current = arr[x][y];
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (arr[i][j] != current) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}

