/*
 문제 : 4779(칸토어 집합)
 시간 : 232ms
 풀이 : 배열을 3등분 해서 가운데는 공백 처리, 왼쪽과 오른쪽은 재귀 수행
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B4779 {
	static char[] cantor;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input; //입력값을 넣을 문자열
        
        while ((input = br.readLine()) != null) { //입력값이 없을 때까지
            int N = Integer.parseInt(input); //N 입력
            
            int length = (int) Math.pow(3, N); //3의 N승만큼의 길이 / Math.pow()는 값을 double로 뱉는다..
            
            cantor = new char[length];
            
            Arrays.fill(cantor, '-'); // 초기 상태 '-'로 초기화

            divide(0, length); // 함수 호출

            sb.append(cantor).append("\n");
        }
        System.out.print(sb);
    }

    static void divide(int start, int length) {
        if (length < 3) {// 길이가 3보다 작으면 더이상 나눌 수 없다
        	return; 
        }

        int part = length / 3;
        Arrays.fill(cantor, start + part, start + 2 * part, ' '); // 가운데 부분 공백 처리

        // 왼쪽과 오른쪽 부분에 대해 재귀 호출
        divide(start, part);
        divide(start + 2 * part, part);
    }
}
