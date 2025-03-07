package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 증가하는 부분 수열 -> 수열의 일부를 뽑았을 때 값이 증가하는 모양

public class B11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int length[] = new int[n]; // 마지막으로 가리키는 녀석까지의 부분 수열 길이를 전부 저장
		int max = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					length[i] = Math.max(length[i], length[j] + 1); // 이렇게 처리하는 이유는 중간에 도로 작아지는 값 때문에 꼬이는 걸 방지할 수 있음
					// 만약 [10, 20, 30, 40, 20, 50] 이라고 하면
					// 40까지 분명 4의 길이였는데
					// 20을 만나면 도로 2가 됨
					// 최댓값 비교를 하고 있으니까 50까지의 길이는 (40까지 길이) + 1 이 되므로 꼬이는 걸 피했음
				}
			}
			max = Math.max(max, length[i] + 1);
		}

		bw.write(max + "");
		bw.flush();

		br.close();
		bw.close();
	}
}
