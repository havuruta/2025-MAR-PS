import java.util.Scanner;

public class B18511 {
    static boolean[] visit; // 사용 가능한 숫자를 체크하는 배열
    static int[] nums; // 사용할 수 있는 숫자 목록
    static int number; // 주어진 숫자 N
    static int length; // 사용할 수 있는 숫자의 개수 K
    static int max = 0; // N 이하의 가장 큰 수
    static int minNum; // N과 자릿수가 같은 최소 숫자 (100, 1000 등)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        number = sc.nextInt(); // N 입력 받기
        length = sc.nextInt(); // K 입력 받기 (사용할 수 있는 숫자 개수)

        int a = Integer.toString(number).length(); // N의 자릿수 계산

        // N과 같은 자릿수의 최소값을 만들기 (예: N=500이면 minNum=100)
        String min = "";
        for (int i = 0; i < a; i++) {
            if (i == 0) {
                min += "1"; // 첫 자리는 1
            } else {
                min += "0"; // 나머지는 0
            }
        }
        minNum = Integer.parseInt(min);

        nums = new int[length + 1]; // 사용할 수 있는 숫자 배열
        visit = new boolean[10]; // 0~9 숫자 사용 여부 체크 배열

        // K개의 숫자 입력받고 visit 배열 업데이트
        for (int i = 0; i <= length; i++) {
            visit[i] = true; // 기본적으로 사용 가능하도록 설정
        }
        for (int i = 1; i <= length; i++) {
            nums[i] = sc.nextInt(); // 사용할 수 있는 숫자 입력받기
            visit[nums[i]] = false; // 해당 숫자는 사용할 수 있도록 false 설정
        }

        // 백트래킹 함수 호출 (초기 depth 0, sum="")
        BBBig(0, "");

        System.out.println(max); // 결과 출력
    }

    // 백트래킹 함수: 가능한 숫자를 조합하여 N 이하의 최댓값 찾기
    static void BBBig(int depth, String sum) {
        if (depth == Integer.toString(number).length() - 1) {
            // 현재 숫자의 자릿수가 N과 같아질 때
            if (number >= Integer.parseInt(sum)) { // N보다 작거나 같은 경우 갱신
                max = Math.max(max, Integer.parseInt(sum));
            }
            for (int idx : nums) { // 가능한 숫자를 추가하면서 백트래킹
                if (!visit[idx]) {
                    sum += Integer.toString(idx);
                    BBBig(depth + 1, sum);
                    sum = sum.substring(0, sum.length() - 1); // 마지막 숫자 제거 (백트래킹)
                }
            }
        } else if (depth == Integer.toString(number).length()) {
            // 깊이가 N의 자릿수와 같아지면 비교 후 종료
            if (number >= Integer.parseInt(sum)) {
                max = Math.max(max, Integer.parseInt(sum));
            }
        } else {
            // 자릿수가 부족한 경우 계속 숫자를 추가하면서 탐색
            for (int idx : nums) {
                if (!visit[idx]) {
                    sum += Integer.toString(idx);
                    BBBig(depth + 1, sum);
                    sum = sum.substring(0, sum.length() - 1); // 마지막 숫자 제거 (백트래킹)
                }
            }
        }
    }
}
