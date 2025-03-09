package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 오르막 수는 자리가 오름차순
// 인접한 수가 같아도 오름차순

public class B11057 {
	public static void main(String[] args) throws IOException {
		// 입력: 1<= N <= 1,000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// n = 1, 10(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
		// n = 2, 55(11, 12, 13, 14, 15, 16, 17, 18, 19, 22, 23, 24, 25, 26, ,,,)
		// 1(90) + 2(80) + 3(70) + 4(60) + 5(50) + 6(40) + 7(30) + 8(20) + 9(10) + 10(0으로 시작할 수 있으니까 1의 자리 수)
		// 1 + 3 + 6 + 10 + 15 + 21 + 28 + 36 + 45 + 55

		int[][] arr = new int[n][10];
		
		for (int i = 0; i < 10; i++) {
				arr[0][i] = i + 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				if(j == 0) {
					arr[i][j] = arr[i - 1][j];
					continue;
				}
				arr[i][j] = (arr[i - 1][j] + arr[i][j - 1])  % 10007; // 문제에서는 출력에다 하라고 했지만 어차피 곱셈의 분배 법칙 같은거 생각해보면 여기서 해도 상관없음
			}
		}

		// 출력 (오르막수 개수) % 10,007
		
		int res = arr[n - 1][9]; // 실은 저 위치에서 안하면 long형으로 처리해도 오버플로우 터져서 답 안나옴

		bw.write(res + "");
		bw.flush();

		br.close();
		bw.close();
	}
}
