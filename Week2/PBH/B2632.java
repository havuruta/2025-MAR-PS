import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2632 {

    static int blue = 0; // 파란색 색종이 개수를 저장하는 변수
    static int white = 0; // 흰색 색종이 개수를 저장하는 변수
    static int[][] color; // 색종이 정보를 저장하는 2차원 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

        int N = Integer.parseInt(br.readLine()); // 색종이의 한 변 길이 (N x N)
        color = new int[N][N]; // N x N 크기의 색종이 배열 생성

        // 색종이 데이터 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken()); // 색종이 값 저장 (0: 흰색, 1: 파란색)
            }
        }

        cut(0, 0, N); // (0,0)부터 N x N 크기의 색종이를 잘라나가기 시작

        // 최종 결과 출력
        sb.append(white + "\n"); // 흰색 색종이 개수 추가
        sb.append(blue); // 파란색 색종이 개수 추가
        System.out.println(sb); // 결과 출력
    }

    // (x, y) 좌표에서 시작하는 size x size 크기의 색종이를 확인하여 분할하는 함수
    static void cut(int x, int y, int size) {
        int value = color[x][y]; // 현재 영역의 첫 번째 색상 값 저장
        boolean same = true; // 해당 영역이 하나의 색상으로 이루어져 있는지 확인하는 변수

        // 주어진 영역이 한 가지 색으로 이루어져 있는지 검사
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color[i][j] != value) { // 하나라도 다른 색이 나오면 분할해야 함
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) { // 만약 한 가지 색으로 이루어져 있다면
            if (value == 1) {
                blue++; // 파란색 색종이 개수 증가
            } else {
                white++; // 흰색 색종이 개수 증가
            }
            return; // 더 이상 나눌 필요 없으므로 종료
        } else { // 여러 색상이 섞여 있으면 4등분으로 나누어 재귀 호출
            int changeSize = size / 2; // 색종이 크기를 절반으로 줄이기
            cut(x, y, changeSize); // 왼쪽 위
            cut(x + changeSize, y, changeSize); // 오른쪽 위
            cut(x, y + changeSize, changeSize); // 왼쪽 아래
            cut(x + changeSize, y + changeSize, changeSize); // 오른쪽 아래
        }
    }
}
