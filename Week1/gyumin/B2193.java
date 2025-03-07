package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// 제일 처음 비트 자리는 검사할 필요 없이 1로 시작하면 됨
		// n = 1, 1
		// n = 2, 1/0
		// n = 3, 10/0 10/1
		// n = 4, 100/0 101/0 100/1
		// n = 5, 1000/0 1001/0 1010/0 1010/1 1000/1
		// n = 6, 10000/0 10010/0 10100/0 10101/0 10001/0 10000/1 10010/1 10100/1
		// -> 1, 2 만 빼면 끝이 0인 건 지난번 전체만큼, 끝이 1인건 지난번에 0으로 끝난 것만큼

		long[][] save = new long[2][n + 1];
		save[1][1] = 1;
		// 조건을 안걸면 1이 들어왔을 때 죽어버림
		if (n >= 2) {
			save[0][2] = 1;
		}
		for (int i = 3; i <= n; i++) {
			save[0][i] = save[1][i - 1] + save[0][i - 1];
			save[1][i] = save[0][i - 1];
		}

		long res = save[0][n] + save[1][n];

		bw.write(res + "");
		bw.flush();

		br.close();
		bw.close();
	}
}
