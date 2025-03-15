package changmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* B9184 신나는 함수 실행
 * https://www.acmicpc.net/problem/9184
 */
public class B9184 {
	
	static int[][][] dp = new int[21][21][21]; //편의상 21로
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    	
    	while(true) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		//숫자 3개
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if(a == -1 & b == -1 && c == -1) { //다 -1 -> 종료
    			break;
    		}
    		
    		int ans = w(a,b,c); //계산값
    		 		
    		bw.write("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
    public static int w(int a, int b, int c) {
    	
    	if(a <= 0 || b <= 0 || c <= 0) { // 셋중 하나라도 0이하면 1
    		return 1;
    	}
    	
    	if (a > 20 || b > 20 || c > 20) { // 20이상인 값이 있으면 20 20 20으로
            return w(20, 20, 20);
        }
    	
    	if (dp[a][b][c] != 0) { // 이미 값을 계산해서 있다 -> 그대로 반환
            return dp[a][b][c];
        }
    	
    	if (a < b && b < c) { // a < b 면서 b < c 인경우
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            
        } else { //그 외
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    	
    	return dp[a][b][c]; //계산한거 리턴해주기
    }
}
