package gyumin_week3;

import gyumin_week3.exceptions.UnderflowException;
import gyumin_week3.exceptions.OutOfBoundException;

public class Queue<T> {
    private T[] array;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // 전체 배열을 복사하는 과정이 필요해서 O(N)
    private void resize() {
        T[] newArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % capacity];
        }
        array = newArray;
        front = 0;
        rear = size;
        capacity *= 2;
    }

    // 원형 큐를 구현하기 위해서는 두 포인터는 배열 내부를 계속 순회할 수 있어야 함
    private int next(int index) {
        return (index + 1) % capacity;
    }

    // 배열 기반 구현이기에 O(1)
    void enqueue(T value){
        if(size == capacity){
            resize();
        }

        rear = next(rear);

        array[rear] = value;
        size++;
    };

    // 제일 처음 값을 꺼내니까 O(1)
    T dequeue(){
        if(size == 0){
            throw new UnderflowException();
        }

        T temp = array[front];

        front = next(front);
        size--;

        return temp;
    };

    // 제일 처음 값을 보여주니까 O(1)
    T peek(){
        if(isEmpty()){
            throw new OutOfBoundException();
        }
        return array[front];
    };
    boolean isEmpty(){
        return size == 0;
    };
    int size(){
        return size;
    };
    void clear(){
        capacity = 10;
        array = (T[]) new Object[capacity];
        front = size = rear = 0;
    };

}
