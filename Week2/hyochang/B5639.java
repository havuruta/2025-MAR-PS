package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B5639 {
	// 5639 - 이진 검색 트리
	// 전위 순회 결과를 보고 후위 순회 결과로 출력

	// 전위 순회 - DFS형식으로 루트 왼쪽노드 오른쪽
	// 후위 순회 - 왼쪽 오른쪽 루트
	// 왼쪽 자식 -> 제일 작음
	// 오른쪽 자식-> 제일 큼
	// 루트-> 중간값
	// 트리 구현 후 후위 순회로 출력
	// 입력 - 이전 값과 비교하여서 이전값보다 커지면 오른쪽 노드
    static class Node {
        int root;
        Node left;
        Node right;

        public Node(int root) {
            this.root = root;
        }
    }
	static Node root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int num = sc.nextInt();

			root = add(root, num);
		}

		postorder(root);
	}

	private static void postorder(Node node) {// 노드가 없으면 종료
		if (node == null) {
			return;
		}
		// 순서 맞춰서 왼쪽 오른쪽 부모
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.root);

	}

	private static Node add(Node node, int num) {
		if (node == null) {
			return new Node(num);
		}
		if (num < node.root) {
			node.left = add(node.left, num);
		} else {
			node.right = add(node.right, num);
		}
		return node;
	}

}