package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*B2447 별찍기 10
 * https://www.acmicpc.net/problem/2447
 */
public class B2447 {
	
	static char[][] stars;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	stars = new char[N][N]; //별찍기 배열
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			stars[i][j] = ' '; //일단 기본 공백
    		}
    	}
    	
    	star(0, 0, N); //별찍기
    	
    	for(int i = 0; i < N; i++) { //출력
    		bw.write(stars[i]);
    		bw.write("\n");
    	}
    	
    	bw.flush();
    	bw.close();
    }
    
    public static void star(int x, int y, int size) {
    	if(size == 1) { //사이즈 1 -> 별찍기
    		stars[x][y] = '*';
    		return;
    	}
    	
    	int newSize = size / 3; //다음 사이즈 
    	
    	for(int i = 0; i < 3; i++) { 
    		for(int j = 0; j < 3; j++) {
    			if(i == 1 && j == 1) { //가운데 공백
    				continue;
    			}
    			star(x + i*newSize, y + j*newSize, newSize); //다시 작은 부분 별찍기
    		}
    	}	
    }
}
 