package problem;

import java.io.IOException;
import java.util.Scanner;

public class B2193 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long [] arr = new long [N+1];
		
		arr[0] = 0; // 0번째 자리는 0개 > 0자리수
		arr[1] = 1; // 1 자리수 는 1 무조건 1개
		
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		} // 결국 내가 구하는 i는 i-2와 이전 인덱스 개수를 더한 값
		// N =5일경우 경우의 수는 5개
    }
}
