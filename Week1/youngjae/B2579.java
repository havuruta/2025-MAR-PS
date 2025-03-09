package problem;

import java.io.IOException;
import java.util.Scanner;

public class B2579 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] stair = new int [N+1];
		int [] score = new int [N+1];
		for(int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		} // 시작점 빼고 계단 부터 입력받기
		// 0 10 20 15 25 10 20
		
		// 끝까지 가는 경우의 수는 n-3 > n-1 > n, n-2 > n
		score[1] = stair[1];
		if (N >= 2) {
			score[2] = stair[1] + stair[2]; // 2번 계단까지는 어차피 그 전꺼랑 자기 더해도 ok 조건에 안걸림
		}
		for (int i = 3; i <= N; i++) {
			score[i] = Math.max(score[i-2], score[i-3] + stair[i-1]) +stair[i];
		}
		System.out.println(score[N]);
    }
}
