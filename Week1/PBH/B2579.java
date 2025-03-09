import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//문제 계단 오르기
// https://www.acmicpc.net/problem/2579
public class B2579 {

    static int max;
    static int N;
    static int[][] nums;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) {
            nums[i][0] = Integer.parseInt(br.readLine());
        }
        nums[1][1] = nums[1][0];  //여러가지 식을 쓰면서 배열의 크기나 더하는 값 중에 필요 없는 함수가 있음
        nums[1][2] = nums[1][0];
        for (int i = 2; i <= N; i++) {
//            nums[i][1] = nums[i - 1][0] + nums[i][0];
            nums[i][2] = nums[i - 2][0] + nums[i][0];
            nums[i][0] = Math.max(nums[i - 2][0] + nums[i][0], nums[i - 1][2] + nums[i][0]);
          //특정 계단에서 최대인 수는 두칸 전의 최대 값에서 두칸 건너 현재값ㅂ을 더한 수
            //전 계단에서 두칸 전의 수를 더했던 수에 현재값을 더한 값 중 하나 이라 그중 max를 구해서 출력
        }

        sb.append(nums[N][0]);
        System.out.println(sb);

    }

}