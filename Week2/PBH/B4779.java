import java.io.*;
import java.util.Arrays;

public class B4779 {

    static char[] lineArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String input; //입력 값

        while ((input = br.readLine()) != null) { //입입력값이 없을 때까지 반복
            int N = Integer.parseInt(input); //입력 값 N => 3의 N승
            sb = new StringBuilder(); //진행할때마다 초기회

            int len = (int) Math.pow(3, N); //3의 N승

            lineArr = new char[len]; //3의 N승 만큼의 크기를 가진 배열
            Arrays.fill(lineArr, '-'); //모든 요소를 1로 설정

            divide(0, len); //메소드 호출

            for(int i = 0; i < lineArr.length; i++){
                sb.append(lineArr[i]);
            }
            System.out.println(sb);
        }
        br.close();
    }

    //3등분해서 가운데는 공백으로 두는 로직 (파라미터 : 구역 시작점, 해당 구역의 길이)
    static void divide(int start, int length) {
        //길이가 3보다 작으면 3등분할 수 X => 종료
        if(length <= 1){
            return;
        }

        //3등분으로 쪼개기 위한 변수 값
        int newlength = length/3;

        //가운데 공백(두번째 구역)으로 바꾸기
        for(int i = start+newlength; i < start+newlength*2; i++){
            lineArr[i] = ' ';
        }

        //첫번째 구역 쪼개기
        divide(start, newlength);

        //세번째 구역 쪼개기
        divide(start+newlength*2, newlength);
    }
}