package Week4changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*B17471 게리맨더링
 * https://www.acmicpc.net/problem/17471
 */
public class B17471 {

	static int N; // 선거구의 수
	static int[][] graph; // 구역 연결정보
	static int min; // 최솟값
	static boolean[] colors; // 각 구역별 색
	static int[] people; // 각 구역별 인구수

	static int color; // 어떤 선거구역의 개수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 최솟값 초기화
		min = Integer.MAX_VALUE;

		// 구역의 수
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		colors = new boolean[N+1];
		graph = new int[N + 1][]; // 입력값이랑 맞추기 위해 N+1로 구역번호 맞춰둠

		// 인구수 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 구역 연결 입력받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()); // 연결된 구역의 수
			graph[i] = new int[c]; // 배열 초기화
			for (int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N - 1; i++) { // 구역의 수만큼 할거임
			color = i;
			comb(0,1);
		}

		if (min == Integer.MAX_VALUE) { // 만약 구역을 나눌 수 없었으면
			bw.write("-1");
		} else {
			bw.write(min + "");
		}

		bw.flush();
		bw.close();
		br.close();

	}

	public static void comb(int depth, int idx) { // depth ->한 선거구의 개수 , idx -> 어디까지 했는지
		if (depth == color) {
			// 선거구의 색이 다 정해진것 -> 여기서 검증해
			boolean isOK = verify();
			if (isOK) {
				// 검증 ok 면 차이구해
				int diff = 0;
				for (int i = 1; i <= N; i++) {
					if (colors[i]) {
						diff += people[i];
					} else {
						diff -= people[i];
					}
				}

				min = Math.min(min, Math.abs(diff));
			}

			return;
		}

		for (int i = idx; i <= N; i++) {
			if (!colors[i]) {
				colors[i] = true;
				comb(depth + 1, i);
				colors[i] = false;
			}
		}

	}
	
	public static boolean verify() {
		//두 구역별 따로 검증해야할듯?
		boolean[] visited = new boolean[N+1];
		
		int t = 0;
		int f = 0;
		//t와 f인 대표지역 한개씩 선정 
		//지역이 없는 경우는 없음 메인에서 각 지역구의 개수를 정해줌
		for(int i = 1; i <= N; i++) {
			if(t != 0 && f != 0) {
				break;
			}
			if(t == 0 && colors[i]) {
				t = i;
			}
			if(f == 0 && !colors[i]) {
				f = i;
			}
		}

		//bfs해서 검증 ㄱ
		if(!bfs(t, true, visited)) {
			return false;
		}
		
		if(!bfs(f, false, visited)) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean bfs(int start, boolean type, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
	    queue.offer(start);
	    visited[start] = true;
	    int count = 1; // 방문한 노드 개수

	    while (!queue.isEmpty()) {
	        int node = queue.poll();
	        for (int next : graph[node]) {
	            if (!visited[next] && colors[next] == type) { //아직 방문하지 않았고, type과 선택한 지역이 같은경우
	                visited[next] = true; //방문처리
	                queue.offer(next); //큐에 넣기
	                count++; //카운트 올리기
	            }
	        }
	    }

	    // type 그룹의 크기와 방문한 노드 수가 일치해야 함
	    int size = 0;
	    if(type) {
	    	size = color;
	    } else {
	    	size = (N - color);
	    }
	    return count == size;

	}

}
