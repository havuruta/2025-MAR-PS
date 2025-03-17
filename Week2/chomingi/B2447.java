package Week2.chomingi;

import java.util.*;
import java.io.*;

public class B2447 {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        star = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        putStar(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(star[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void putStar(int N, int r, int c) {
        if (N == 1) {
            star[r][c] = '*';
            return;
        }

        int dN = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    putStar(dN, r + dN * i, c + dN * j);
                }
            }
        }
    }
}
