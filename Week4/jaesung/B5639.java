package Week2.problem;

/*
 문제 : 5639(이진 검색 트리)
 시간 : 668ms
 풀이 : 재귀함수를 통해 전위 순회에서 루트 기준 왼쪽 서브 트리와 오른쪽 서브 트리를 검출하여 후위 순회를 출력
 */

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class B5639 {
	static int[] pre;

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
		
		pre = new int[10001];
        int idx = 0;

        while (sc.hasNextInt()) {
            pre[idx++] = sc.nextInt();
        }
		
		post(0, idx-1);
	}
	
	static void post(int left, int right) {
		if (left == right) {
			System.out.println(pre[left]);
			return;
		}
		
		if (left > right) {
			return;
		}
		
		int root = pre[left];
		int subLeft = left + 1;
		int subRight = subLeft;
		
		while (pre[subRight] < root && subRight <= right) {
			++subRight;
		}
		
		post(subLeft, subRight-1);
		post(subRight, right);
		
		System.out.println(root);
	}
}