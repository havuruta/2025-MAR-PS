package 진효창;

import java.util.Scanner;

public class B2579 {
	// 2579 - 계단 오르기
	// 시작점에서부터 규칙에 따라 계단을 올라갓을 때의 최댓값을 구하기

	// 그냥 갈때마다 최댓값이 있는 쪽으로 가야하나? | ㅇㅇ
	// 연속 세번인지 확인하는 변수가 있어야하나? | ㄴ
	// 그냥 값 입력을 받고 이전 분기에 값 받은애 안받은애 하고 
	// 받은애는 3번 연속인지 확인해야할듯? | 이거때매 배열만들기할때 쉽지 않음
	// 걍 화분처럼 두줄로 내려가는 배열이면될거같은데->실패... 


	// DP배열을 만듬 배열에 들어갈 값은 밟았을때 제일 큰 점수 넣기
	// 밟을 수 있는 경우는 [n-2]에서 두칸 올라왓을때 [n-3] 에서 2칸올라와 [n-1]를 들러서 온 경우만 있음

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] steps = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			steps[i] = sc.nextInt();
		}
		
		//dp[1], dp[2]는 점화식에 앞서 세팅할때 필요한 값임
		//이 조건문들이 없게된다면 나머지 존재하지 않는 범위를 건듬(ArrayIndexOutOfBounds)발생
		if (n == 1) {
		    System.out.println(steps[1]); 
		    return;
		}
		if (n == 2) {
		    System.out.println(steps[1] + steps[2]); 
		    return;
		}

		dp[1] = steps[1];
		dp[2] = steps[1] + steps[2];

		for (int i = 3; i < n+1; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + steps[i - 1]) + steps[i];
		}

		System.out.println(dp[n]);

	}

}