package Week3.PBH;
//금주에 시간이 좀 없어 순수 제작은 아니고 GPT도움을 받으며 작성하고 분석했습니다.
import java.util.Arrays;

public class Stack<T> {
    private T[] array;      // 데이터를 저장할 배열
    private int capacity;   // 현재 배열 크기
    private int top;        // 스택의 가장 위(top) 요소 인덱스

    // 기본 생성자 - 초기 용량 10으로 설정
    @SuppressWarnings("unchecked")  //제네릭 타입을 배열 타입으로 선언하기 위해
    public Stack() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.top = -1; // 비어있을 때 top은 -1
    }

    // 배열 크기 두 배로 늘리기 - O(n)
    private void resize() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    // 요소 추가 (push) - O(1) 평균, O(n) (resize 시)
    public void push(T value) {
        if (top + 1 == capacity) {
            resize(); // 공간 부족하면 확장
        }
        array[++top] = value; // top 증가 후 값 추가
    }

    // 요소 제거 후 반환 (pop) - O(1)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty"); // 예외 처리
        }
        T value = array[top];
        array[top--] = null; // 값 꺼낸 후 null 처리 & top 감소
        return value;
    }

    // 맨 위 값 확인 (삭제 X) - O(1)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty"); // 예외 처리
        }
        return array[top];
    }

    // 비어있는지 확인 - O(1)
    public boolean isEmpty() {
        return top == -1;
    }

    // 현재 스택 크기 반환 - O(1)
    public int size() {
        return top + 1;
    }

    // 스택 초기화 - O(1)
    @SuppressWarnings("unchecked")   //제네릭 타입을 배열 타입으로 선언하기 위해
    public void clear() {
        this.array = (T[]) new Object[capacity];
        this.top = -1;
    }

}

