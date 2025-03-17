package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/* B4779 칸토어 집합
 * https://www.acmicpc.net/problem/4779
 */
public class B4779 {
	
	static char[] lines;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		
		 while ((input = br.readLine()) != null) {
			 
			int N = Integer.parseInt(input); //입력 숫자
			
			if(N == 0) { //0인경우
				bw.write("-\n");
				continue;
			}
			
			int size = (int) Math.pow(3, N); //N 최대 12라서 여유
			
			lines = new char[size];
			Arrays.fill(lines, '-'); //-로 꽉 채우기
			
//			while(N != 1) { 다시 생각해보니 이렇게하면 못함
//				int start = size/3;
//				int end = (size/3) * 2;
//				
//				for(int i = start; i < end; i++) {
//					lines[i] = 
//				}
//				
//			}
			
			recursion(0, size); //재귀
			
			bw.write(lines);
			bw.write("\n");			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	public static void recursion(int start, int size) {
		
        if (size < 3) { //종료조건
            return;
        }

        int segment = size / 3; //3등분 사이즈
        int leftEnd = start + segment; // 가운데 시작
        int rightStart = start + 2 * segment;  //가운데 끝

        //가운데 공백으로
        for (int i = leftEnd; i < rightStart; i++) {
            lines[i] = ' ';
        }

        //왼쪽부분 오른쪽 부분 각각 재귀
        recursion(start, segment);
        recursion(rightStart, segment);
    }
}
