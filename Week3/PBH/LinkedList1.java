package Week3.PBH;
//금주에 시간이 좀 없어 순수 제작은 아니고 GPT도움을 받으며 작성하고 분석했습니다.
public class LinkedList<T> {

    // 내부 Node 클래스 (제네릭 적용)
    private static class Node<T> {
        T value;      // 저장할 값
        Node<T> next; // 다음 노드를 가리키는 포인터

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head; // 첫 번째 노드
    private int size;     // 리스트의 크기

    // 값 추가 (맨 끝에) - O(n)
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode; // 리스트가 비어있다면 head에 할당
        } else {
            Node<T> current = head;
            while (current.next != null) { // 끝까지 순회
                current = current.next;
            }
            current.next = newNode; // 마지막 노드의 next에 연결
        }
        size++;
    }

    // 특정 인덱스에 값 추가 - O(n)
    public void add(int index, T value) {
        // 인덱스 검사 (size까지 허용)
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<T> newNode = new Node<>(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            // index-1 위치까지 직접 순회
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // 특정 인덱스의 값 반환 - O(n)
    public T get(int index) {
        // 인덱스 검사 (0 ~ size-1 허용)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<T> current = head;
        // index 위치까지 순회
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // 특정 인덱스의 값 제거 - O(n)
    public T remove(int index) {
        // 인덱스 검사 (0 ~ size-1 허용)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        T removedValue;
        if (index == 0) {
            removedValue = head.value;
            head = head.next; // head를 다음으로 이동
        } else {
            // index-1 위치까지 순회
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedValue = current.next.value;
            current.next = current.next.next; // 삭제 대상 skip
        }
        size--;
        return removedValue;
    }

    // 현재 사이즈   시간 복잡도 - O(1)
    public int size() {
        return size;
    }

    // 비어있는거 확인  시간 복잡도 - O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    //  삭제 시간복잡도  - O(1)
    public void clear() {
        head = null;
        size = 0;
    }

    //  인덱스 반환 - 시간복잡도는 찾을 때 까지 반복문을 돌기에 O(n)
    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((value == null && current.value == null) ||
                    (value != null && value.equals(current.value))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // 값이 없으면 -1 반환
    }

    // 값 존재 여부 반환 - O(n)
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

}
