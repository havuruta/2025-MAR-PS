package Week4changmin;

import java.io.*;
import java.util.*;
/*B2470 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class B2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //숫자의 개수
        int[] numbers = new int[N]; //숫자 저장 배열
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(numbers);
        //투포인터 왼쪽 오른쪽
        int left = 0;
        int right = N - 1;
        //최솟값, 최솟값일때 숫자 두개
        int min = Integer.MAX_VALUE; 
        int minNum1 = 0;
        int minNum2 = 0;

        while (left < right) { 
            int sum = numbers[left] + numbers[right]; //왼쪽과 오른쪽의 합
            int abs = Math.abs(sum); //합의 절댓값

            if (abs < min) { //최솟값보다 차이가 적으면 갱신
                min = abs;
                minNum1 = numbers[left];
                minNum2 = numbers[right];
            }

            if (sum < 0) { //합이 0보다 작으면 왼쪽 포인터를 옮김
                left++;
            } else { //0보다 크면 오른쪽 포인터를 옮김
                right--;
            }
        }

        bw.write(minNum1 + " " + minNum2);
        bw.flush();
        bw.close();
        br.close();
    }
}