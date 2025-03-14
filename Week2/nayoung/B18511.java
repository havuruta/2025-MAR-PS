package Week2.nayoung;

import java.util.*;
import java.io.*;

//B18511 큰 수 구성하기
//메모리 16004kb
//시간 140ms
// 문제 목표: 주어진 수 N보다 작거나 같은 가장 큰 수를 K개의 숫자로 조합하여 구하기

public class B18511 {
    static String N;  // 목표 숫자 N
    static int K;  // 사용할 수 있는 숫자의 개수
    static String[] arr;  // K개의 숫자들
    static String[] res;  // 현재 조합을 저장하는 배열
    static int max;  // 최대값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 목표 숫자, K: 사용할 숫자들의 개수
        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // arr: 사용할 수 있는 숫자들을 저장
        arr = new String[K];

        // arr에 K개의 숫자들을 저장
        for (int i = 0; i < K; i++) {
            arr[i] = st.nextToken();
        }

        // res: 현재까지 만든 숫자를 저장할 배열
        res = new String[N.length()];

        // 최대값 초기화
        max = Integer.MIN_VALUE;

        // 숫자 조합을 만드는 함수 호출
        combcomb(0);

        // 결과 출력
        System.out.println(max);
    }

    // 숫자 조합을 만드는 함수 (재귀)
    static void combcomb(int m) {
        // m이 1 이상일 때, 최소 1자리 이상의 숫자가 완성된 경우에만 확인
        if (m > 0) {
            StringBuilder sb = new StringBuilder();
            // res 배열에 담긴 숫자들을 하나로 합쳐서 숫자 만들기
            for (int i = 0; i < m; i++) {
                sb.append(res[i]);
            }
            // 만든 숫자가 N보다 작거나 같으면 최대값을 갱신
            int num = Integer.parseInt(sb.toString());
            if (num <= Integer.parseInt(N)) {
                max = Math.max(max, num);
            }
        }

        // m이 res의 길이를 초과하면 더 이상 숫자를 만들 수 없음
        if (m == res.length) return;

        // arr 배열에서 숫자를 하나씩 골라서 자릿수를 채운다
        for (int i = 0; i < arr.length; i++) {
            res[m] = arr[i];  // 숫자를 선택하여 res 배열에 저장
            combcomb(m + 1);  // 다음 자리에 대해 재귀적으로 숫자 조합
        }
    }
}