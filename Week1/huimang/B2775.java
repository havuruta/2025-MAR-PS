
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2775 {

    static int[][] memo;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            memo = new int[k+1][n+1];

            for(int i = 1; i<=n; i++) {
                memo[0][i] = i;
            }

            for(int i = 1; i<=k; i++) {
                for(int j = 1; j<=n; j++) {
                    memo[i][j] = memo[i][j-1] + memo[i-1][j];
                }
            }
            
            System.out.println(memo[k][n]);
        }



    }


}
