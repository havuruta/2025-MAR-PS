package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* B18511 큰 수 구성하기
 * https://www.acmicpc.net/problem/18511
 */
public class B18511 {

	static int N, K;
	static String[] numbers; // K개의 원소들
	static int max; //가장 큰 수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		max = Integer.MIN_VALUE; //최솟값으로 초기화 N-> 최대 1억임
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		numbers = new String[K]; //K개만큼

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) { //원소들 입력받기
			numbers[i] = st.nextToken();
		}

		int length = String.valueOf(N).length(); //N의 길이(몇자리인지)

		for(int i = 1; i <= length; i++) { //1자리부터 N자리까지 탐색
			findMax(i, 0, new StringBuilder());
		}

		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();

	}

	public static void findMax(int length, int depth, StringBuilder sb) { //완성해야하는 길이, 현재 길이, 만들어지는 수
		if (depth == length) { //현재길이가 완성길이와 같은경우가 종료조건
			int num = Integer.parseInt(sb.toString()); //숫자로 변환
			if (num <= N) { //N보다 작거나 같을때
				max = Math.max(num, max); //만들어진 수들중 최댓값과 비교
			}
			return;
		}
		
		//종료하지 못한경우
		for (int i = 0; i < K; i++) { //원소를 돌면서
			sb.append(numbers[i]); //만들어지는 수에 넣고
			findMax(length, depth + 1, sb); //재귀하고
			sb.deleteCharAt(sb.length() - 1); //넣었던 수 지워주고
		}
	}
}

