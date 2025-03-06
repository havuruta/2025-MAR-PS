package 진효창;

import java.util.ArrayList;
import java.util.Scanner;
public class B1932 {
    // 1932 - 정수 삼각형 
    // 삼각형의 형태로 값이 입력됨-> 제일 위에서부터 내려왓을 때 최댓값인 경우를 찾음
    
	// 1.두개의 리스트를 갱신하면서? 134976kb 876ms
	// 2.5*5배열을 만들고 아래로 내리면서 더하면되나? 132428kb 796ms
	// 3.그냥 n짜리 배열을 만들고 입력받을때마다 더하면 되지 않음? 133004kb 836ms
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] tri = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}		
		//1번 134976kb 876ms
		ArrayList<Integer> pre = new ArrayList<>();
		pre.add(tri[0][0]);
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> cur = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {// pre의 모든 수를 꺼내고 tri에 있는 경우랑 더함 
				int num = tri[i][j];
				int sub = tri[i][j];
				if (j == 0) {// 시작
					num += pre.get(j);
				} else if (i == j) {// 마지막
					num += pre.get(j - 1);
				} else {// 중간에 있는애들은 이전 항목에서 두가지 경우를 고를 수 있는데 두가지 중 최댓값을 더해줌
					num += pre.get(j);
					sub += pre.get(j - 1);
					num = Math.max(num, sub);
				}
				cur.add(num);
			}
			pre = cur;
//		System.out.println(pre);//확인용
		}
		int ans1 = 0;
		for (int p : pre) {
			ans = Math.max(ans1, p);
		}
		System.out.println(ans1);

//         // 2번 132428kb 796ms
// 		// 배열을 내리면서 해당자리에 더하고 해당 자리에 있는 최댓값을적음?
// 		for (int i = 1; i < n; i++) {
// 			for (int j = 0; j < i + 1; j++) {
// 				if (j == 0) {// 제일 앞은 서로 더해줌
// 					tri[i][j] += tri[i - 1][j];
// 				} else if (j == i) {// 끝인 경우
// 					tri[i][j] += tri[i - 1][j - 1];
// 				} else {// 둘 중 큰놈으로 더해줍니다 위에서도 두가지를 고를 수 있고 아래에서도 위에 있는 두개를 고를 수 있음
// 					tri[i][j] += Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
// 				}
// //				System.out.print(tri[i][j] + " ");
// 			}
// //			System.out.println();
// 		}
// 		int ans2 = 0;
// 		for (int i = 0; i < n; i++) {
// 			ans = Math.max(ans2, tri[n - 1][i]);
// 		}
// 		System.out.println(ans2);

//         //3번 133004kb 836ms
// 		//입력받으면서 배열을 더해가면 그냥 끝날듯? 

// 		int[] dp = new int[n];
// 		dp[0] = sc.nextInt();// 1개니까
// 		for (int i = 1; i < n; i++) {
// 			int[] arr = new int[i + 1];
// 			for (int j = 0; j < i + 1; j++) {
// 				int num = sc.nextInt();

// 				if (j == 0)// 시작이면
// 					arr[j] = dp[j] + num;
// 				else if (j == i)
// 					arr[j] = dp[j - 1] + num;
// 				else
// 					arr[j] = Math.max(dp[j - 1], dp[j]) + num;
// 			}
// 			dp = arr;
// 		}
// 		int ans = 0;
// 		for (int d : dp) {
// 			ans = Math.max(ans, d);
// 		}
// 		System.out.println(ans);
	}
}