package Week4changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/* B1074 Z
 * https://www.acmicpc.net/problem/1074
 */
public class B1074 {
	
	static int N,r,c; // 2^N * 2^N 사이즈 배열 , r행 c열은 몇번째 방문인가\
	static int count; //지금 몇번째 까지 왔는지
	static int res; //결과
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int length = (int) Math.pow(2, N); //한변의 크기
		
		find(0,0, length);
		
		bw.write(res-1 + ""); // 0,0 -> 0번째로 찾은거라네요
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void find(int row, int column, int length) {
		if(!isExist(row,column,length)) { //지금 탐색하는 사분면에 없으면 건너뛰고 그만큼 +
			count += length*length;
			return;
		}

		if(length == 1) { //길이가 1이면 이제 숫자셈
			count++;
			if(r == row && c == column) { //찾는거면 값 저장
				res = count;
			}
			return;
		}
		
		int nextSize = length / 2; //다음 재귀를 위한 사이즈
		
		find(row, column, nextSize); //2사분면
		find(row, column+nextSize, nextSize); //1사분면
		find(row+nextSize, column, nextSize); //3사분면
		find(row+nextSize, column+nextSize, nextSize); //4사분면
		
	}
	
	public static boolean isExist(int row, int column, int length) {
		//이 범위안에 있어야 있는거임
		return r >= row && r < row + length && c >= column && c < column + length; 
	}
}
