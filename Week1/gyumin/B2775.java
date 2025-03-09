package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2775 {
	static int [][] apt;
	
	static int bu(int k, int n) {
		// 일단 0층은 채워
		// 근데 누적합으로
		for(int i = 1; i < n; i++) {
			apt[0][i] = i + apt[0][i - 1];
		}
		
		for(int j = 1; j < k; j++) {
			for(int i = 1; i < n; i++) {
				apt[j][i] = apt[j- 1][i] + apt[j][i - 1];
			}
		}
		
		return apt[k - 1][n - 1];
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
        	int k = Integer.parseInt(br.readLine());
        	int n = Integer.parseInt(br.readLine()) + 1;
        	
        	apt = new int [k][n];
        	
        	bw.write(bu(k, n)+"\n");
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}
