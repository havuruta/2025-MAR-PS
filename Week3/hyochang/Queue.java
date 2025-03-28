
import java.util.NoSuchElementException;

/* 참고 목록
 * https://go-coding.tistory.com/6 예시 코드 참고
 * ArrayDeque.class, linkedlist.class 메서드 구성 참고
 * gpt 메서드 구현 및 예외 처리 검토
 * 
 */

public class Queue<T> {
    private Object[] data;
    private int head;
    private int rear;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.head = 0;
        this.rear = 0;
        this.size = 0;
    }

    /*
     * 요구사항
     * Queue(배열 기반, 원형큐) enqueue(value) dequeue() peek() isEmpty()
     * head와 rear를 활용해 구현 확장하는 매서드 resize와 isEmpty를 먼저 구현
     * 
     * 원형 큐를 요구하는 이유
     * -> 삭제하고 계속하여 head가 뒤로 가는 구조임
     * 해당 방법으로 가게되면 남는 배열이 생겨 비효율적임 -> 원형으로 만들어 해결
     * 
     */

    public boolean isEmpty() {// O(1)
        return size == 0;
    }

    private void resize() {// O(n) amortized O(1)
        Object[] newdata = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            // 선형 큐에서는 head + i 로 복사하면 되지만,
            // 원형 큐는 head가 배열의 끝을 넘어갈 수 있으므로
            // (head + i) % data.length 로 실제 인덱스를 조정
            newdata[i] = data[(head + i) % data.length];
        }
        data = newdata;
        // 원형 큐니까 시작과 끝을 다시 초기화
        head = 0;
        rear = size;
    }

    public void enqueue(T value) {// O(1)
        if (size == data.length) {// 발생시 O(n)
            resize();
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    public int size() {// O(1)
        return size;
    }

    public T dequeue() {// O(1)
        if (size == 0) {
            // 비어있으면 예외처리
            throw new NoSuchElementException("큐 비었음");
        }
        @SuppressWarnings("unchecked")
        T result = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return result;
    }

    public T peek() {// O(1)
        if (size == 0) {
            // 비어있으면 예외처리
            throw new NoSuchElementException("큐 비었음");
        }
        @SuppressWarnings("unchecked")
        T result = (T) data[head];
        return result;
    }

    public void clear() { // O(n)
        for (int i = 0; i < size; i++) {
            data[(head + i) % data.length] = null;
        }
        head = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public String toString() {// O(n)
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < size; i++) {
            sb.append(data[(head + i) % data.length]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append(">");
        return sb.toString();
    }

}
