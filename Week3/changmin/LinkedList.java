package Week3.changmin;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	private Node<T> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	private static class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	void add(T value) { // 사이즈 0 -> 시간복잡도 O(1), 아닐경우 O(n) 마지막 노드까지 이동한 후 추가해야하기 때문
		if (size == 0) { // 사이즈가 0일경우
			Node<T> node = new Node<>(value);
			node.next = head;
			head = node;
			size++;
			return;
		}

		// 사이즈가 0이 아닌경우
		Node<T> node = new Node<>(value); // 마지막에 들어갈 새로운 노드

		Node<T> curr = head; // 리스트의 시작점

		while (curr.next != null) { // 다음 노드가 없을때까지 이동
			curr = curr.next; // 다음노드로 이동
		}
		// 다 돌고 나오면 이제 마지막노드의 다음 자리에 새로 더할 노드를 넣어줌
		curr.next = node;
		size++; // 크기++
	};

	void add(int index, T value) { // 사이즈가 0인경우 O(1), 아닌경우 O(n)

		if (index < 0 || index > size) { // 리스트가 범위를 벗어났을 경우
			throw new IndexOutOfBoundsException("인덱스가 리스트 범위를 벗어났습니다");
		}

		if (size == 0) { // 사이즈가 0인경우
			Node<T> node = new Node<>(value);
			node.next = head;
			head = node;
			size++;

		} else if (index == size) { // 마지막에 넣는경우 그냥 add 호출
			add(value);
			return;

		} else { // 중간에 끼워넣는 경우

			Node<T> node = new Node<>(value); // 새로 들어가는 노드
			Node<T> pre = get(index - 1); // 내가 넣고 싶은 자리의 바로 전 노드

			node.next = pre.next; // 새로운 node의 next를 pre의 next로 바꿔주고
			pre.next = node; // pre의 next 를 node로 바꿔줌
			size++;
		}
	};

	T get(int index) { // 0인덱스 -> O(1) 아닐경우 O(n)
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("인덱스가 리스트 범위를 벗어났습니다");
		}

		if (index == 0) { // 0번 인덱스를 찾을경우 바로 반환
			return head.value;
		}

		Node<T> node = head; // 노드의 처음부터 탐색할것

		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.value;
	};

	T remove(int index) { // idx 0 -> O(1) 아닐경우 O(n)
		if (head == null) {
			throw new NullPointerException("리스트가 비어있습니다");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("인덱스가 리스트 범위를 벗어났습니다");
		}

		if (index == 0) { // 제일 앞 제거시 바로 제거
			T res = head.value;
			head = head.next;
			size--;
			return res;
		}

		Node<T> pre = get(index - 1); // 지울 노드의 바로 앞
		Node<T> removeNode = pre.next; // 지울 노드
		T res = removeNode.value;

		pre.next = removeNode.next; // 바로 앞 노드의 다음을 지울 노드의 다음으로 변경
		size--;

		return res;
	};

	int size() { // 사이즈는 그냥 반환
		return size;
	};

	boolean isEmpty() { // 사이즈 0 true 아니면 false
		return size == 0;
	};

	void clear() { // head를 null로 바꿔버리고 size를 0으로 / 원래 있던것은 GC가 처리해줄 예정
		head = null;
		size = 0;
	};

	// 시간복잡도는 O(n)
	int indexOf(T value) {
		int index = 0;
		boolean isOK = false;
		Node<T> tmp = head;

		while (tmp != null) {
			if (tmp.value.equals(value)) {
				isOK = true;
				break;
			}

			tmp = tmp.next;
			index++;
		}

		if (!isOK) {
			// 찾는 값이 없을경우? 예외처리 or -1 등 그냥 원하는데로 할수 있음
//    		throw new NoSuchElementException("찾는 값이 없습니다");
			return -1;
		}
		return index;
	};

	// 시간복잡도는 O(n)
	boolean contains(T value) {
		boolean isOK = false;
		Node<T> tmp = head;

		while (tmp != null) {
			if (tmp.value.equals(value)) {
				isOK = true;
				break;
			}

			tmp = tmp.next;
		}

		return isOK;
	};

}