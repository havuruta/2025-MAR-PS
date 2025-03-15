package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* B2630 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 */

public class B2630 {
	
	static int N; //한변의 길이
	static int[][] paper; //색종이색 배열 
	static int blue; //파란색 개수
	static int white; //하얀색 개수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); //한변의 길이
		
		blue = 0;  //0개로 초기화
		white = 0;
		paper = new int[N][N]; //배열 생성
		
		for(int i = 0; i < N; i++) { //입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(N, 0, 0); //재귀 ㄱㄱ
		
		
		bw.write(white + "\n" + blue); //출력
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void paper(int length,int x, int y) { //종이 자르기
		
		if(length == 1) { //길이가 1인경우 끝
			if(paper[x][y] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		int blueC = 0; //현재 탐색 영역에서 파란색 개수 하얀색 개수
		int whiteC = 0;
		
		for(int i = x; i < x+length; i++) { //색 검사 
			for(int j = y; j < y+length; j++) {
				if(paper[i][j] == 1) {
					blueC++;
				} else {
					whiteC++;
				}
			}
		}
		
		if(blueC == 0) { //색이 한개인 경우 끝
			white++;
			return;
		} else if(whiteC == 0) {
			blue++;
			return;
		}
		
		//위에서 return하지 못했으면 더 잘라봐야 함
		
		int half = length / 2; // 길이 절반으로
        paper(half, x, y); // 2사분면
        paper(half, x, y + half); // 1사분면     
        paper(half, x + half, y); // 3사분면
        paper(half, x + half, y + half); //4사분면
		
	}
}
