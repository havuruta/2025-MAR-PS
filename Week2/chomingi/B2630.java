package Week2.chomingi;

import java.util.*;
import java.io.*;

public class B2630 {
    static boolean[][] paper;
    static int blue, white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new boolean[N][N];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++) paper[i][j] = (Integer.parseInt(st.nextToken())==1) ? true : false;
        }
        blue = 0;
        white = 0;
        
        countPaper(N,0,0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void countPaper(int N, int r, int c){
        if (isOneColor(N, r, c)){
            if (paper[r][c]) blue++;
            else white++;
            return;
        }

        int dN = N>>1;
        for (int i = 0; i<2; i++){
            for (int j = 0; j<2; j++){
                countPaper(dN, r+i*dN, c+j*dN);
            }
        }
    }

    static boolean isOneColor(int N, int r, int c){
        boolean s = paper[r][c];

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (s!=paper[r+i][c+j]) return false;
            }
        }

        return true;
    }

}
