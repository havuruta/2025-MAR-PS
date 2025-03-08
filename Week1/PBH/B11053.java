import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//문제 가장 긴 증가하는 부분 수열
//https://www.acmicpc.net/problem/11053
public class B11053 { 

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] nums = new int[T + 1][2];
        nums[0][0] = 0;
        nums[0][1] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= T; i++) {  //입력값을 입력
            int a = Integer.parseInt(st.nextToken());
            nums[i][0] = a;
        }
        int maxLength = 0;
        ;
        for (int i = 1; i <= T; i++) {  //배열의 값을 순회
            int a = nums[i][0];
            int max = 0;
            for (int j = 0; j <= i; j++) { //시작 부터 현재 값 까지의 배열의 값 중 현재 값보다 작은 값들이 가진 최대 길이 순열을 구함
                if (nums[i][0] > nums[j][0]) {
                    max = Math.max(max, nums[j][1]);
                }
            }
            nums[i][1]=max+1;       //최대 순열 +1 에서 저장
            maxLength = Math.max(maxLength, nums[i][1]); //각 자리의 최대 길이 수열중 가장 긴 값 출력
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();

    }

}
