package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B1662 {
	// 1662 - 압축
	// 압출된 문자열 S 를 보고 원래 문자열의 길이를 구한다.

	// K(Q) = Q가 K개
	// 33(562(71(9))) - 3567979567979567979
	// 제일 깊은 괄호에서 부터 나오면서 변환
	// 문자열을 돌면서 스택에 넣음 나오면서 해당 연산
	// 해당 문제를 재귀로 풀어보려고 하였으나 하나의 메서드에서 해결이 되어버림
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		System.out.println(restore(str));
	}

	private static int restore(String str) {
		Stack<Integer> stack = new Stack<>();
		int length = 0;
		int multi = 1;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isDigit(c)) {//정수면 k인지 q인지 확인인
				if (i + 1 < str.length() && str.charAt(i + 1) == '(') {//앞에 괄호가 잇으면 k
					multi = c - '0';
				} else {//아니면 Q 자리수를 누적
					length++;
				}
			} else if (c == '(') {//여는 괄호면
				stack.push(length);
				stack.push(multi);
				length = 0;//초기화
				multi = 1;
			} else if (c == ')') {//닫는 괄호면 안의 수의 길이 * 한자리수 곱
				int prevm = stack.pop();
				int prevl = stack.pop();
				length = prevl + (length * prevm);// 괄호 외부 길이 + (괄호 내부 길이 * K)
			}
		}
		//마무리는 닫는 괄호니까 length반환
		return length;
	}
}