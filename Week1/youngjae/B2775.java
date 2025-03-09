package problem;

import java.io.IOException;
import java.util.Scanner;

public class B2775 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(want(k, n));
        }

    }

    static int want(int k, int n) { // k층, n호
        if (k == 0)
            return n; // 0층이면 그냥 n만
        if (n == 1)
            return 1; // 1호면 1명 끝

        return want(k - 1, n) + want(k, n - 1); // a-1층 1호부터 b호까지

    }
}
