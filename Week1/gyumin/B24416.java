package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B24416 {
	static int a;
	static int b;
	
	static int fib(int n) {
	
		if(n <= 2){
			// 여기가 탈출 조건이니까~
           	a++;
            return 1;  
        } 
		else return (fib(n - 1) + fib(n -2));
	}
	static int fibo(int n, int [] arr) {
		arr[1] = arr[2] = 1;
		
		for(int i = 3; i < arr.length; i++) {
			// 여기서 연산을 하니까~
			b++;
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		return arr[n];
	}
	
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        fib(n);
        fibo(n, new int [n + 1]);
        
        bw.write(a + " " + b);
        bw.flush();
        
        br.close();
        bw.close();
    }
}
