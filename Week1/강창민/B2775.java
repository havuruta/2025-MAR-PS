package 강창민;

import java.util.Scanner;

//B2775 부녀회장이 될테야
/* 
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.

이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 */
public class B2775 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 수
		int T = sc.nextInt();
		
		//ㅌㅔ케만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			
			//찾아야하는값
			int floor = sc.nextInt();
			int ho = sc.nextInt();
			
			// 아파트 거주자 수를 저장할 배열
            //(층 * 호 수) + 호 수 (0층 까)
			int[] people = new int[(floor*ho) + ho];
			
			// 0층 값 설정
			for (int j = 0; j < ho; j++) {
			    people[j] = j + 1;
			}

			// 층별 거주자 수 계산
			for (int i = 1; i <= floor; i++) {
				
				// i층의 1호는 항상 1명 거주
			    people[i * ho] = 1;
			    
			 // i층 j호에는 (i층 j-1호의 사람 수 + (i-1)층 j호의 사람 수)
			    for (int j = 1; j < ho; j++) {
			        people[i * ho + j] = people[i * ho + j - 1] + people[(i - 1) * ho + j];
			    }
			}
			
		
		System.out.println(people[floor*ho + ho - 1]);
			
			
			
			
			
			
			
			
		}
	}

}

