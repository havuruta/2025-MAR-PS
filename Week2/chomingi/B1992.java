package Week2.chomingi;

import java.io.*;

public class B1992 {
    static boolean[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j)=='1' ? true : false;
            }
        }

        quadTree(N, 0, 0);
        System.out.println(sb.toString());
    }

    static void quadTree(int N, int sY, int sX){
        if (isCompressible(N, sY, sX)) sb.append(arr[sY][sX] ? 1 : 0);
        else {
            sb.append("(");
            quadTree(N>>1, sY, sX);
            quadTree(N>>1, sY, sX+(N>>1));
            quadTree(N>>1, sY+(N>>1), sX);
            quadTree(N>>1, sY+(N>>1), sX+(N>>1));
            sb.append(")");
        }
        return;
    }
    
    static boolean isCompressible(int N, int sY, int sX){
        boolean start = arr[sY][sX];

        for (int r = 0; r<N; r++){
            for (int c = 0; c<N; c++){
                if (start != arr[sY+r][sX+c]) return false;
            }
        }
        return true;
    }
}