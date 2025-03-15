import java.util.Arrays;
import java.util.Scanner;

public class B18511 {
	static int N; 
	static int K;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int [K];
		for(int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}
		
		//N보다 작지만 max인 K값 수들의 집합 중 큰 값
		for (int i = 0; i < K; i++) {
			perm(arr[i]);
		}
		
		System.out.println(max);
	}
	
	static void perm(int currentNum) {
		// 기저조건
		if (currentNum > N) {
			return;
		}
		
		max = Math.max(max, currentNum);
		
		// 재귀조건
		for (int i = 0; i < K; i++) {
			int num = currentNum * 10 + arr[i];
			perm(num);
		}
		
	}
}
