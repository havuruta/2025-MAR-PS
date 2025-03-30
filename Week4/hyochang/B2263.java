import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2263 {
	// 2263 - 트리의 순회
	// 인오더 포스트 오더를 보고 원래 트리를 알아내고
	// 프리오더로 출력

	// 인오더 - 중위(왼 루 오)
	// 포스트오더 - 후위(왼 오 루)
	// 프리오더 - 전위 (루 왼 오)
	// 포스트오더 마지막은 현재 트리의 루트
	// 인오더를 통해서 누가 왼쪽 오른쪽인지 판단
	static int[] in, post;// 인오더, 포스트 오더
	static Map<Integer, Integer> map = new HashMap<>();// 인 순서 저장용
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		in = new int[n];
		post = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			in[i] = num;
			map.put(num, i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}

		find(0, n - 1, 0, n - 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void find(int inst, int inend, int postst, int postend) {
		if (inst > inend || postst > postend) {
			return;
		}
		int root = post[postend];
		sb.append(root).append(" ");

		int idx = map.get(root);
		int left = idx - inst;

		find(inst, idx - 1, postst, postst + left - 1);
		find(idx + 1, inend, postst + left, postend - 1);
	}
}
