package chomingi;

import java.io.*;
import java.util.*;

public class B24416 {
    static int func1, func2;
    static int[] fiboMemo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        func1 = 0;
        func2 = 0;

        fiboMemo = new int[N+1];

        fiboMemo[1] = 1;
        fiboMemo[2] = 1;

        fibo(N);
        fiboWithMemo(N);
        
        System.out.println(func1+" "+func2);
    }   

    static int fibo (int n){
        if (n == 1 || n == 2){
            func1++;
            return 1;
        }
        else return (fibo(n-1) + fibo(n-2));
    }

    // DP는 곧 메모이제이션
    static int fiboWithMemo (int n){
        if (fiboMemo[n]!=0) return fiboMemo[n];
        else {
            int now = fiboWithMemo(n-1) + fiboWithMemo(n-2);
            fiboMemo[n] = now;
            func2++;
            return now;
        }
    }
}
