package problem;

import java.io.IOException;
import java.util.Scanner;

public class B24416 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fibonacci(n);
        System.out.println((count + 1) + " " + (n - 2));
        // n-2인 이유 : for문을 n-2번 실행하므로
    }

    public static int fibonacci(int n) {
        // 기저 조건
        // 1과 2는 return 1
        if (n == 1 || n == 2) {
            return 1;
        }
        count++;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}