package Week2.nayoung;

import java.util.*;
import java.io.*;

//B4779 칸토어 집합
//메모리 22520kb
//시간 300ms
public class B4779 {
    static StringBuilder sb;  // 결과를 저장할 StringBuilder
    static int N;  // Sierpinski Carpet의 크기를 결정하는 N 값
    static int len;  // 각 테스트 케이스에서 생성할 문자열의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 입력을 받는다.
            String tmp = br.readLine();

            // 빈 입력이거나 종료 조건이면 반복문 종료
            if (tmp == null || tmp.isEmpty()) {
                break;
            }

            N = Integer.parseInt(tmp);  // N 값 읽기
            len = (int) Math.pow(3, N);  // 문자열의 길이는 3^N

            sb = new StringBuilder();
            // 길이에 맞게 "-"로 초기화
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            // Sierpinski Carpet을 만들기 위해 분할 정복 수행
            divideConquer(0, len - 1);

            // 결과 출력
            System.out.println(sb.toString());
        }
    }

    // 분할 정복 함수: start ~ end 구간에서 가운데 1/3을 공백으로 처리
    static void divideConquer(int start, int end) {
        int len = end - start + 1;

        // 종료 조건: 길이가 3보다 작으면 더 이상 나눌 수 없으므로 종료
        if (len < 3) {
            return;
        }

        // 구간을 3등분한 후 가운데 1/3을 공백으로 처리
        int midStart = start + len / 3;  // 가운데 시작 인덱스
        int midEnd = start + len / 3 * 2;  // 가운데 끝 인덱스

        // 가운데 1/3 구간을 공백으로 설정
        for (int i = midStart; i < midEnd; i++) {
            sb.setCharAt(i, ' ');  // setCharAt을 사용해 한 문자씩 변경
        }

        // 나머지 두 구간에 대해 재귀 호출
        divideConquer(start, midStart - 1);  // 왼쪽 구간
        divideConquer(midEnd, end);  // 오른쪽 구간
    }
}