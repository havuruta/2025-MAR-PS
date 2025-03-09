package problem;

import java.io.IOException;
import java.util.Scanner;

public class B11057 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N + 1][10]; // 5까지면 5 인덱스도 있어야하니까 N+1

        // N이 1이면 -> 자기 자신
        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        /*
         *    0 1 2 3 4 5 6 7 8 9
         * 1  1 1 1 1 1 1 1 1 1 1
         * 2  10 9 8 7 6 5 4 3 2 1
         * 3  55 >> 
         * 
         */
        // 길이가 i일때
        for (int i = 1; i < N + 1; i++) { // N행 (개수) 만큼 <저 표를 만들거야>
            for (int j = 0; j < 10; j++) { // 각자리수를 표현
                for (int k = j; k < 10; k++) { // 오르막이어야함 따라서 k는 j부터 반복
                    arr[i][j] += arr[i - 1][k]; // 
                    arr[i][j] %= 10007; // 출력예시
                }
            }
        }
        System.out.println(arr[N][0] % 10007);
    }
}
