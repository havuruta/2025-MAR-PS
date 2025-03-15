import java.util.Scanner;

public class B1992 {
    static int length; // 영상의 크기 (N x N)
    static int[][] tree; // 영상을 저장할 2차원 배열
    static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 받기 위한 Scanner 객체 생성
        length = sc.nextInt(); // 영상 크기 입력 받기 (N)
        tree = new int[length][length]; // N x N 크기의 배열 생성

        // 영상 데이터 입력 받기
        for (int i = 0; i < length; i++) {
            String a = sc.next(); // 한 줄씩 입력받음 (0과 1로 구성된 문자열)
            for (int j = 0; j < length; j++) {
                tree[i][j] = Integer.parseInt(String.valueOf(a.charAt(j))); // 문자열의 문자를 정수로 변환하여 배열에 저장
            }
        }

        zip(0, 0, length); // (0,0)에서 시작하여 전체 영상 압축
        System.out.println(sb); // 결과 출력
    }

    // (x, y)에서 시작하는 size x size 크기의 영상 압축하는 함수
    static void zip(int x, int y, int size) {
        int value = tree[x][y]; // 현재 영역의 첫 번째 값 저장
        boolean check = true; // 해당 영역이 하나의 값으로 이루어져 있는지 확인하는 변수

        // 주어진 영역이 한 가지 숫자로 이루어져 있는지 검사
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tree[i][j] != value) { // 하나라도 다른 숫자가 나오면 분할해야 함
                    check = false;
                    break;
                }
            }
            if (!check) break;
        }

        if (check) { // 만약 한 가지 숫자로 이루어져 있다면
            sb.append(value); // 그 숫자를 결과에 추가
        } else { // 여러 숫자가 섞여 있다면 4등분하여 압축
            size = size / 2; // 크기를 절반으로 줄이기
            sb.append("("); // 현재 영역을 괄호로 묶음 (분할 시작)
            zip(x, y, size); // 왼쪽 위
            zip(x, y + size, size); // 오른쪽 위
            zip(x + size, y, size); // 왼쪽 아래
            zip(x + size, y + size, size); // 오른쪽 아래
            sb.append(")"); // 분할이 끝났으므로 괄호 닫기
        }
    }
}
