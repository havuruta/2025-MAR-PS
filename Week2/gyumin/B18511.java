package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B18511 {
	static int n;
	static int k;
	static int[] pick;
	static int[] elements;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int temp = n;
		int size = 0;
		
		while(temp != 0) {
			temp /= 10;
			size++;
		}

		pick = new int[size];
		elements = new int[k];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < k; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		} // 요소 입력

		select(0);
		
		bw.write(res+"");
		bw.flush();
		
		br.close();
		bw.close();

	} // main

	private static void select(int count) {
		compare(); // pick.length 는 주어진 자연수로 만들 수 있는 최대 길이일 뿐, 못 채워도 정답일 수 있음
		
		if (count >= pick.length) {
			return;
		}

		for (int i = 0; i < k; i++) // 중복을 허용하지 않는 문제였다면 (int i = idx; i <= k - pick.length + count; i++), pick.length <= k
		// 중복을 허용하기 때문에 idx 추적 및 범위 조정 x
		{
			pick[count] = elements[i];
			select(count + 1);
			pick[count] = 0; // compare() 에서 수를 반환하는 로직에 따라 0으로 초기화
		}
	}

	private static void compare() {
		int temp = 0;
		for (int i = 0; i < pick.length; i++) {
			temp += pick[i] * Math.pow(10, i);
		}

		if (temp > res && temp <= n)
			res = temp;
		return;
	}
}
