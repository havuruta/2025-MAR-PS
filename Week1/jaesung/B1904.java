package jaesung;

/*
 문제 : 1904(01타일)
 시간 : 188ms
 풀이 : 피보나치 수열과 같은 규칙성을 가지므로 이를 활용하여 입력 인덱스까지 값을 계산하여 출력.
 */

import java.io.IOException;
import java.util.Scanner;

public class B1904 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[1000001];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		
		System.out.println(arr[N]);
	}
}
