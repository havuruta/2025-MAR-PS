import java.util.Scanner;

//문제 부녀회장이 될테야
//https://www.acmicpc.net/problem/2775
public class B2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] people = new int[15][15];   //입력값이 <=14 라서 넉넉하게 15로 했습니다.
        for (int i = 0; i < people.length; i++) {
            people[0][i] = i + 1;           //0층 사람들을 입력해줍니다.
        }

        for (int i = 1; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                for (int k = 0; k <= j; k++) {
                    people[i][j] += people[i - 1][k];   //각 호수의 사람들을 구해서 저장해줍니다.
                }
            }
        }
        int[] result = new int[T];

        int K = 0;
        int N = 0;
        for (int i = 0; i < T; i++) {   //입력값이 들어오면 해당하는 호수의 인원을 출력합니다.
            K = sc.nextInt();
            N = sc.nextInt();
            result[i] = people[K][N - 1];
        }

        for (int i = 0; i < result.length; i++) {  //한달 전에 풀었던 문제라 마음대로 푼 느낌이 있습니다.
            System.out.println(result[i]);
        }
    }
}