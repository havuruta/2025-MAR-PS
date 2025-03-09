import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제 알고리즘 수업-피보나치 수1
public class B24416 {//단순히 피보나치 함수를 재귀와 DP방식으로 풀어보는 문제 였기에 문제에 제시 되어 있는 코드 구현에 충실 했습니다.

    static int num=0;              //공용 카운트 변수
    static int numDp=0;
    static int[]f;

    static void fib(int n) {
        if(n==1||n==2) {
            num++;
            return;
        }else {
            fib(n-1);   //재귀로 구현
            fib(n-2);
        }
    }

    static void fibonacci(int n) {

        for(int i=3;i<=n;i++) {        //DP로 구현
            f[i]=f[i-1]+f[i-2];
        }
        numDp=n-2;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        f=new int[n+1];
        f[0]=1;
        f[1]=1;
        fib(n);
        fibonacci(n);
        sb.append(num+" "+numDp);             //입력 후 출력
        System.out.println(sb);
    }

}
