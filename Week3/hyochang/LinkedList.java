/* 참고 목록
 * https://you88.tistory.com/26 예시 코드 참고
 * linkedlist.class 매서드 구성 참고
 * gpt 메서드 구현 및 예외 처리 검토
 * 
 */

public class LinkedList<T> {
	// Node 내부 클래스 정의 -> GPT
	// 실습용으로 외부 클래스여도 상관없음
	// 일반적으로는 Node를 LinkedList 내부에 둠
	// -> 외부에 노출될 필요 없고, 캡슐화를 통해 안전하게 관리할 수 있음
	private static class Node<T> { // 노드객체 제네릭으로 (자료형을 정해줌)
		// 노드가 가지고 있는 것 = 데이터 + 다음 노드의 주소값
		T data;
		Node<T> next;

		public Node(T data) { // 생성자
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	/*
	 * 요구사항
	 * Linkedlist(단일 연결 리스트) add(value) add(index, value) remove(index)
	 * get(index) size()
	 * 
	 * getNode를 먼저 구현해서 해당 메서드로 여러 메서드 구현에 사용할 예정
	 * linkedlist.class의 node(int index)
	 * 
	 */

	private Node<T> getNode(int index) {// O(n)
		// linkedlist의 node(int index) 기능
		// 이렇게 만들면 add와 remove를 할 때 특정 노드를 가져올 수 있어서 유용
		// 추가적으로 set도 구현이 쉬워진다.

		if (index < 0 || index >= size) { // 인덱스가 음수이거나 범위를 초과한 경우
			throw new IndexOutOfBoundsException("인덱스 초과");
		}

		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current;
	}

	public T get(int index) { // O(n) 값을 반환해주는 메서드
		return getNode(index).data;
	}

	public void add(T value) { // 값을 추가하면 제일 마지막에
		// 1. value를 담을 노드 생성
		Node<T> newNode = new Node<>(value);

		// 2. LinkedList에 넣어야함
		// 2-1. 제일 처음 = 헤드가 null
		if (head == null) {
			head = newNode;
		} else {
			// 2-2. 아닌 경우
			// getNode(size-1)로 조회 후 연결
			Node<T> last = getNode(size - 1);
			last.next = newNode;
		}
		size++;
	}

	public void add(int index, T value) {// O(n) 인덱스 자리에 연결하는 메서드

		// 여기에서도 예외처리를 해야함 -> gpt
		// 궁금한 점 -> getNode에서 index 검사를 해주는데 왜 함??
		// index=0인 경우에 getNode는 -1을 찾게됨
		// 애초에 설계과정에서 getNode에는 유효한 값이 들어가도록 정함

		if (index < 0 || index > size) {// 같은 경우는 add와 동일한 경우
			throw new IndexOutOfBoundsException("인덱스 초과");
		}

		// 1. 노드 생성
		Node<T> newNode = new Node<T>(value);
		// 0이면 앞에
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			// 2. 연결할 노드 찾기
			Node<T> first = getNode(index - 1);
			// 2-1. next인수인계
			newNode.next = first.next;
			first.next = newNode;
		}
		size++;
	}

	public void remove(int index) {// O(n) 삭제 메서드
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("인덱스 초과");
		}

		if (index == 0) {
			head = head.next;
		} else {
			Node<T> pre = getNode(index - 1);// 지울 노드를 추적하는 노드
			pre.next = pre.next.next;
			// 객체를 삭제해야하는지?
			// GPT => 객체는 GC가 잘 삭제해준다 메모리 해제와는 무관
		}
		size--;
	}

	public void set(int index, T value) {// O(n) 수정 메서드
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("인덱스 초과");
		}

		Node<T> cur = getNode(index);
		cur.data = value;
	}

	public int size() {// O(1) 크기
		return size;
	}

	public void clear() {// O(n) 초기화
		// O(1)이 아닌 이유 GC가 연결을 끊는 시간 고려?
		head = null;
		size = 0;
		// remove 메서드에서 했던 고민인 node 관리와 유사
		// 반복문으로 모두 null로 바꾸어 줘도 되지만
		// 자바에서는 해당 기능정도만 있어도 충분
	}

	public int indexOf(T value) { // O(n)
		Node<T> current = head;
		int index = 0;
		while (current != null) {
			if (value == null) {
				if (current.data == null) {
					return index;
				}
			} else {
				if (value.equals(current.data)) {
					return index;
				}
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(T value) { // O(n)
		return indexOf(value) != -1;
	}

	@Override
	public String toString() {// O(n) 출력

		// linkedlist.class에는 tostring 메서드가 없어서
		// 굳이를 몰랏는데
		// 상속한 AbstractCollection에 tostring()이 오버라이딩

		StringBuilder sb = new StringBuilder();

		sb.append("<");

		Node<T> current = head;
		while (current != null) {
			sb.append(current.data);
			if (current.next != null) {
				sb.append(", ");
			}
			current = current.next;
		}

		sb.append(">");

		return sb.toString();
	}

	// getNode() 메서드를 기반으로 구현된 메서드는 모두 시간복잡도 O(n)
	// 탐색이나 삽입 속도를 개선 방안
	// 1. tail이라는 Node를 만들어 관리
	// 2. 노드 자체에 앞 뒤의 값을 가질 수 있게 하여 양방향에서 값을 추적
	// -> 단일 연결 리스트를 바탕으로 양방향 연결 리스트로
}