package Week4changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*B7576 토마토
 * https://www.acmicpc.net/problem/7576
 */
public class B7576 {

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	static int M, N; // M 가로칸수 / N 세로칸수
	static int[][] box; // 상자 정보
	static int day = 0; // 일수
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // 이미 익은 토마토면 큐에 삽입
					queue.offer(new int[] { i, j });
				}
			}
		}

		bfs(); //토마토 익히는중..

		boolean ok = true;
		// 모든 토마토가 익었는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					ok = false;
					break;
				}
			}
			if (!ok) { // 탈출용
				break;
			}
		}

		if (ok) { // 익었으면
			bw.write(day + "");
		} else { // 다 안익었으면
			bw.write(-1 + "");
		}
		bw.flush();
		bw.close();
		br.close();

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size(); // 지금 큐에 담긴 토마토개수
			boolean ok = false; // 한개라도 익은 토마토가 있는지 확인

			for (int i = 0; i < size; i++) {
				int[] findXY = queue.poll();
				int x = findXY[0];
				int y = findXY[1];
				for (int j = 0; j < 4; j++) {
					int dx = x + di[j];
					int dy = y + dj[j];
					if (dx >= 0 && dx < N && dy >= 0 && dy < M && box[dx][dy] == 0) { // 상자 안쪽, 아직 익지않은
						box[dx][dy] = 1; // 익혀주고
						queue.offer(new int[] { dx, dy }); // 큐에 넣음
						ok = true; // 익은토마토 체크
					}
				}

			}
			if (ok) { // 한개라도 익었으면 ++
				day++;
			}

		}
	}

}
