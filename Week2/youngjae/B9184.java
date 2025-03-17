
import java.util.Scanner;

public class B9184 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 종료 조건: -1 -1 -1일 때 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // 결과 출력
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, func(a, b, c));
        }

        sc.close();
    }

    static int func(int a, int b, int c) {
        // 기저조건: a, b, c가 0 이하일 때 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 기저조건: a, b, c가 20을 넘으면 20으로 처리
        if (a > 20 || b > 20 || c > 20) {
            return func(20, 20, 20);
        }

        // 재귀조건
        if (a < b && b < c) {
            return func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);
        }

        return func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
    }
}
