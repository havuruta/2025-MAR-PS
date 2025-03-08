package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B24416 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//입력값
		int N = Integer.parseInt(br.readLine()); 
		
		//피보나치값 재귀호출횟수 배열(피보나치 배열아님)
		int[] fiboRe = new int[N];
		
		//첫번째와 두번쨰 값 저장
		fiboRe[0] = 1;
		fiboRe[1] = 1;
		
		//피보나치 수 호출 몇번했는지 저장
		for(int i = 2; i < N; i++) {
			fiboRe[i] = fiboRe[i-1] + fiboRe[i-2];
		}
		
		//출력 (N-2 -> dp사용시 실행 횟수)
		bw.write(fiboRe[N-1] + " " + (N-2));
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}

