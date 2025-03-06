package 진효창;

import java.util.Scanner;

public class B2565 {
    // 2565 - 전깃줄
	// dp배열을 만듬(길이는 최댓값만큼)? 500고정
	// 값이 있는 dp배열
	// 목표지점이 더 크다= 이미 겹침 근데 큰애 = 작은애+1처리
	// 애초에 선택이 안되면 선이 없음 0으로 되잇어서 상관없을듯

	// 전깃줄 연결 여부는?
	// 2차원?->i= 현재 기둥 j=연결되어있는 위치? 
	// 1차원으로 하면 똑같이 500짜리만들고
	// 입력받으면서 최댓값구하고 그걸 기억

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dp = new int[501]; // DP 배열 선언 (최대 500까지)
		int[] wire = new int[501]; // 각 기둥에 연결된 목표 기둥 저장
		int n = sc.nextInt(); // 전깃줄의 개수 입력

		int max = 0; // 기둥 번호의 최댓값을 추적

		for (int i = 0; i < n; i++) {
			// cur은 현재 위치, target은 목표
			int cur = sc.nextInt();
			int target = sc.nextInt();
			wire[cur] = target; // 해당 기둥에 연결된 목표 기둥 저장
			max = Math.max(max, Math.max(cur, target)); // 최댓값 갱신
		}

		dp[0] = 0;
		for (int i = 1; i <= max; i++) {
			if (wire[i] != 0) {// 기둥에서 전깃줄이 있으면
				dp[i] = 1;
			}
			for (int j = 1; j < i; j++) {
				// wire[i] < wire[j]이면 전깃줄이 교차
				if (wire[i] > wire[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1); 
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= max; i++) {
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(n - ans); // 교차하는 전깃줄 수 출력
	}
}
