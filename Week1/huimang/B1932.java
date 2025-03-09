
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1932 {
    
    
    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N][N];

        int[][] dp = new int[N][N];

        

        // 입력 받고
        for(int i = 0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j<inputs.length; j++) {
                tri[i][j] = Integer.parseInt(inputs[j]);
            }
        }


        // 가보자 
        dp[0][0] = tri[0][0];

        for(int i = 1; i<N; i++) {
            for(int j = 0; j<N; j++) {

                // 왼쪽으로 긁으면서 내려올 때의 값 저장.
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + tri[i][j];
                }

                // 오른쪽으로 긁으면서 내려올때의 값 저장.
                else if(j==i) {
                    dp[i][j] = dp[i-1][j-1]+ tri[i][j];
                }
                // 그게 아니면, 왼쪽 오른쪽 비교해서 더 큰값이랑 더해서 저장!!
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0; i<N; i++) {

            // 마지막 행에서 가장 값이 큰 친구를 담아주쟈~~
            if(max<dp[N-1][i]) {
                max = dp[N-1][i];
            }
        } 
        

        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        


    }
}
