import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class B9184 {
    static int[][][] dp = new int[21][21][21]; //문제 자체를 잘 이해를 못해서 찾아보니 3차원 배열로 값을 저장하라 해서 이렇게 시작했습니다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)    //입력의 마지막이면 탈출
            {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c){

        if(needCalc(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];      //배열에 값이 존재하는 입력이라면 배열에서 값 출력
        }

        if(a <=0 || b<=0 || c<= 0)  //하나라고 0이면 1출력
        {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {   //입력 중 하나라도 20이 넘으면 20,20,20값
            return dp[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c); //재귀를 하면서 배열에 값을 담아줌
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    static boolean needCalc(int a, int b, int c){
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}