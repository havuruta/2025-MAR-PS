package gyumin_week3;

import gyumin_week3.exceptions.OutOfBoundException;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    void add(T value) {
        // 크기가 0이면 그냥 head에 새 노드 할당하면 됨 -> O(1)
        if (size <= 0) {
            head = new Node<T>(value);
            size++;
            return;
        }
        // 그게 아니라면 마지막 노트 찾아가야 함 -> O(N)
        Node<T> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        // 제일 마지막 찾았으면 그냥 노트 추가
        temp.next = new Node<T>(value);
        size++;

    };

    void add(int index, T value) {
        // 크기보다 인덱스가 크거나 같으면 그냥 예외처리
        if (index >= size) {
            throw new OutOfBoundException();
        }
        // 제일 앞에 추가 -> O(1)
        if (index == 0) {
            Node<T> temp = head;
            head = new Node<T>(value);
            head.next = temp;
            size++;
        }
        // 나머지 -> O(N)
        else {
            Node<T> newNode = new Node<T>(value);
            Node<T> temp = head;

            // 삽입 위치 idx 보다 1 전으로 가야
            // temp.next를 newNode.next에 넣고
            // temp.next를 ndwNode로 변경 가능
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    };

    T get(int index) {
        // 크기보다 인덱스가 크거나 같으면 그냥 예외처리
        if (index >= size) {
            throw new OutOfBoundException();
        }
        // 제일 앞 값 반환 -> O(1)
        if (index == 0) {
            return head.value;
        }
        // 나머지 -> O(N)

        Node<T> temp = head;

        // 이번엔 인덱스까지 가기
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp.value;
    };

    T remove(int index) {
        // 크기보다 인덱스가 크거나 같으면 그냥 예외처리
        if (index >= size) {
            throw new OutOfBoundException();
        }

        Node<T> temp = head;

        // 제일 앞 값 삭제 -> O(1)
        if (index == 0) {
            head = head.next;
            size--;
            return temp.value;
        }
        // 나머지 -> O(N)
        T res = null;
        // 삽입 위치 idx 보다 1 전으로 가야
        // temp.next.value를 저장하고
        // temp.next를 temp.next.next로 변경
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        res = temp.next.value;

        temp.next = temp.next.next;
        size--;

        return res;
    };

    int size() {
        // 그냥 사이즈 값만 보면 되는 메서드 1 -> O(1)
        return size;
    };

    boolean isEmpty() {
        // 그냥 사이즈 값만 보면 되는 메서드 2 -> O(1)
        return size == 0;
    };

    void clear() {
        // 헤드를 밀어버리면 나머지는 어차피 가리키질 못함
        // 나중에 gc가 한번에 처리
        // -> O(1)
        head = null;
        size = 0;
    };

    int indexOf(T value) {
        int idx = 0;
        boolean isFound = false;
        Node<T> temp = head;

        // 다 찾아가면서 equals로 찍어봐야 함 -> O(N)
        while(temp != null){
            if(value.equals(temp.value)){
                isFound = true;
                break;
            }

            temp = temp.next;
            idx++;
        }

        if(!isFound){
            throw new NoSuchElementException();
        }

        return idx;
    };

    boolean contains(T value) {
        boolean isFound = false;
        Node<T> temp = head;

        // 다 찾아가면서 equals로 찍어봐야 함 -> O(N)
        while(temp != null){
            if(value.equals(temp.value)){
                isFound = true;
                break;
            }

            temp = temp.next;
        }

        return isFound;
    };

}