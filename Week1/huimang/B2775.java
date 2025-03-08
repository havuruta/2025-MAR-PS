
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775 {


    // 초기값을 보관하고 있을 memoizatioin 배열.. 이게 맞나..?? 바텀 업 맞나요?
    static int[][] memo;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            memo = new int[k+1][n+1];

            // 초기 값을 지정
            for(int i = 1; i<=n; i++) {
                memo[0][i] = i;
            }


            // 바텀업 방식인가...?? 작은 부분부터 큰 부분까지 memoization 배열에 저장해나가면서 큰 문제를 해결함
            for(int i = 1; i<=k; i++) {
                for(int j = 1; j<=n; j++) {
                    memo[i][j] = memo[i][j-1] + memo[i-1][j];
                }
            }
            
            System.out.println(memo[k][n]);
        }



    }


}
