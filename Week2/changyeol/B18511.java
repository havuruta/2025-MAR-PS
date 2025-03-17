/*
 문제 : 18511(큰 수 구성하기)
 시간 : 112ms
 풀이 : 구성된 수가 N보다 커질때까지 재귀를 수행하며 최댓값을 갱신.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B18511 {
	static int N;
	static int max = Integer.MIN_VALUE;
    static List<Integer> digits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // N 입력
        digits = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            digits.add(Integer.parseInt(st.nextToken()));  // 사용할 숫자 리스트
        }

        dfs(0);
        
        System.out.println(max);
    }

    static void dfs(int num) {
        if (num > N) {
        	return; // N을 초과하면 종료
        }
        
        max = Math.max(max, num); // 최댓값 갱신

        for (int digit : digits) {
            dfs(num * 10 + digit); // 다음 자릿수를 추가
        }
    }
}