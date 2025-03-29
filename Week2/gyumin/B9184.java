package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B9184 {
	// a, b, c 의 값을 인덱스 삼아서 3차원 배열에 저장하는 방식으로 메모이제이션 구현
	// 어차피 21 이상의 값이 들어오면 20으로 줄여버림
	static int[][][] memory = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] input = new int[3];

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 97; i < 100; i++) {
				input[i - 'a'] = Integer.parseInt(st.nextToken());
			} // 입력

			if (input['a' - 'a'] == -1 && input['b' - 'a'] == -1 && input['c' - 'a'] == -1)
				break; // 셋 다 -1이면 종료

			int res = w(input['a' - 'a'], input['b' - 'a'], input['c' - 'a']);

			sb.append(String.format("w(%d, %d, %d) = %d\n", input['a' - 'a'], input['b' - 'a'], input['c' - 'a'], res));
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	} // main

	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		if (a > 20 || b > 20 || c > 20) {
			if (memory[20][20][20] == 0)
				memory[20][20][20] = w(20, 20, 20);
			return memory[20][20][20];
		}

		if (memory[a][b][c] != 0)
			return memory[a][b][c]; // 저장한 값이 있으면 바로 리턴

		if (a < b && b < c) {
			memory[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			return memory[a][b][c];
		}

		return memory[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

	} // w
}
