package jaesung;

/*
 문제 : 18511(큰 수 구성하기)
 시간 : 172ms
 풀이 : 구성된 수가 N보다 커질때까지 재귀를 수행하며 최댓값을 갱신.
 */

import java.util.Scanner;

public class B18511 {
    static int N;
	static int ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int K = sc.nextInt();
		
		arr = new int[K];
		for (int i = 0; i < K; i++) 
			arr[i] = sc.nextInt();
		
		ans = 0;
		find(0);
		
		System.out.println(ans);
	}
	
	static void find(int val) {
		if (val > N) return;
		
		ans = Math.max(ans, val);
		
		for (int i = 0; i < arr.length; i++) 
			find(val *10 + arr[i]);
	}
}
