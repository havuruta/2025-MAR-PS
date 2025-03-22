package Week3.PBH;
//금주에 시간이 좀 없어 순수 제작은 아니고 GPT도움을 받으며 작성하고 분석했습니다.
public class Queue<T> {
    private T[] array;       // 요소를 담을 배열
    private int capacity;    // 현재 배열 용량
    private int front;       // 첫 번째 요소 인덱스
    private int rear;        // 마지막 요소 인덱스 (다음 들어갈 자리)
    private int size;        // 요소 개수

    // 기본 생성자 - 초기 용량 10
    @SuppressWarnings("unchecked")
    public Queue() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // 내부 메서드: 배열 크기 두 배로 확장 - O(n)
    @SuppressWarnings("unchecked")  //이 구문을 사용해야 제네릭으로 배열생성이 가능하다고 해서 만들어줌
    private void resize() {
        T[] newArray = (T[]) new Object[capacity * 2];
        // 순서 대로 다시 복사
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % capacity];
        }
        array = newArray;
        front = 0;
        rear = size;
        capacity *= 2;
    }

    // 순환 큐용 인덱스 계산 - O(1)
    private int next(int index) {
        return (index + 1) % capacity;
    }

    // 요소 추가 (enqueue) - O(1) (resize 발생 시 O(n))
    public void enqueue(T value) {
        if (size == capacity) {
            resize(); // 꽉 찼으면 확장
        }
        array[rear] = value;      // rear 위치에 값 추가
        rear = next(rear);        // rear 위치 이동 (순환 처리)
        size++;                   // 크기 증가
    }

    // 요소 제거 (dequeue) - O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty"); //큐가 비어 있으면 예외 처리
        }
        T value = array[front];
        array[front] = null;      // 가비지 컬렉션을 위해 null 처리
        front = next(front);      // front 이동
        size--;                   // 크기 감소
        return value;
    }

    // 첫 번째 요소 반환 (삭제 X) - O(1)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty"); // 예외 처리
        }
        return array[front];
    }

    // 비어있는지 체크 - O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // 현재 크기 반환 - O(1)
    public int size() {
        return size;
    }

    // 큐 초기화 - O(1)
    @SuppressWarnings("unchecked")
    public void clear() {
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

}