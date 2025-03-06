
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B24416 {

    // memoization을 위해.
    static int[] memo;
    

    // 각 호출 횟수를 카운트 하기 위해.
    static int countRe = 0;
    static int countDp = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        // memoization용 배열을 하나 맹글어줌.
        memo = new int[N+1];
        

        // 재귀호출
        fib1(N);

        // 메모이제이션 호출
        fib2(N);

        bw.write(String.valueOf(countRe) + " " + String.valueOf(countDp));
        bw.flush();
        bw.close();
    }


    // 재귀로 풀기.
    public static int fib1(int n) {
        
        if(n == 1 || n == 2) {

            // 리턴하는 곳에서 카운트 증가.
            countRe++;
            return 1;
        }

        return fib1(n-1) + fib1(n-2);

    }


    // DP로 풀기
    public static int fib2(int n) {
        
        // 우선은 초반에 예측되는 값을 넣어줌.
        memo[1] = memo[2] = 1;

        // 이후부터, 이전의 값을 이용해서 메모이제이션용 배열에 계속해서 저장.
        for(int i = 3; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];

            // 카운트 증가.
            countDp++;
        }
        
        return memo[n];
    }
}
