

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제 정수 삼각형
//https://www.acmicpc.net/problem/1932
public class B1932 {

    static int[][] t;

    static int max = 0;
    static int height = 0;

    static void Calc(int N) {
        while (N <= height) {
            for (int i = 1; i < t[N].length; i++) { //각 행 열의 값을 위에서 받을 수 있는 값 두 개 중 더 큰 수를 현재 값에 더해서 저장
                t[N][i] = Math.max(t[N][i] + t[N - 1][i - 1], t[N][i] + t[N - 1][i]);
            }
            N++;
        }
        for (int i = 1; i < t[height].length; i++) {  //마지막 행에서 최대인 수를 답으로 저장
            max = Math.max(max, t[height][i]);
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        height = Integer.parseInt(br.readLine());
        t = new int[height + 1][height + 1];
        for (int i = 1; i <= height; i++) {    //값을 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Calc(1);
        sb.append(max);
        System.out.println(sb);
    }

}
