package Week3.problem;

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

    private int next(int index) {
        return (index + 1) % capacity;
    }

    void enqueue(T value){
        return;
    };
    T dequeue(){
        return null;
    };
    T peek(){
        return null;
    };
    boolean isEmpty(){
        return false;
    };
    int size(){
        return 0;
    };
    void clear(){
        return;
    };

}
