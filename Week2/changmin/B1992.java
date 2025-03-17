package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* B1992 쿼드트리
 * https://www.acmicpc.net/problem/1992
 */

public class B1992 {
	
	static int N; //영상의 크기
	static char[][] data; //영상 정보
	static StringBuilder sb; //출력 만들기
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		data = new char[N][N];
		sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) { //입력받기
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				data[i][j] = line.charAt(j);
			}
		}
		
		compress(N, 0, 0); //길이 N이고 0,0기준으로 탐색 시작
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	//압축?
	public static void compress(int length, int x , int y) {
		//길이가 1이면 한칸이니까 그 위치의 데이터를 저장 후 return
		if(length == 1) { 
			if(data[x][y] == '1') {
				sb.append("1");
			} else {
				sb.append("0");
			}
			return;
		}
		
		//탐색해야하는 곳 데이터 개수 변수
		int zero = 0;
		int one = 0;
		
		//탐색
		for(int i = x; i < x+length; i++) {
			for(int j = y; j < y+length; j++) {
				if(data[i][j] == '1') { //1일경우 1++
					one++;
				} else {
					zero++; //0일경우 0++
				}
			}
		}
		
		if(zero == 0) { //0이 0개 -> 1만 존재
			sb.append("1");
			return; //데이터가 모두 같으니까 return
		} else if(one == 0) { //반대로 1이 0개 -> 0만 존재
			sb.append("0");
			return; //데이터가 모두 같으니까 return
		}
		
		//여기까지 왔으면 길이가 1도 아니고, 한가지 데이터로 이루어진것이 아님
		int half = length/2; //이제 절반으로 나눠서 다시 탐색
		
		sb.append("("); //괄호 추가 하고 남은 부분들 탐색
		compress(half, x, y); //좌상단
		compress(half, x, y+half); //우상단
		compress(half, x+half, y); //좌하단
		compress(half, x+half, y+half); //우하단
		sb.append(")"); //괄호 닫기
	}
}

