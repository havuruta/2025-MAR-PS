
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 풀이 : 현재 요소의 앞 요소를 봤을 때, 자기보다 크냐 작냐를 먼저 구분을 해 줌.
 * 자기보다 작다? 그럼 증가하는 수열임
 * 자기 자신보다 작은 수의 수를 저장하기 위해 카운트 배열을 하나 생성 해 줌.
 * 전부 1로 초기화 -> 자기 자신도 증가하는 수열이 될 수 있으니깐.
 * loop를 돌며 자기자신보다 작은 수 이고, 단지 작기만 하면, 갱신 시 2가 되니까 자기보다 cnt가 큰 수여야지만 갱신 하도록 함/
 */
public class B11053 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        int[] cnts = new int[N];
        
    
        Arrays.fill(cnts, 1);
        int max = 1;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<i;j++) {
                if(arr[i] > arr[j] && cnts[i]  < (cnts[j]+1)) {
                    cnts[i] = cnts[j]+1;
                    max = Math.max(max, cnts[i]);
                }
            }    
        }
        
        
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();


    }
}
