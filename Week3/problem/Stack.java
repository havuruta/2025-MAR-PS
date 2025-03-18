package Week3.problem;

import java.util.Arrays;

public class Stack<T> {
    private T[] array;
    private int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.top = -1;
    }

    private void resize() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    void push(T value){
        return;
    };
    T pop(){
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
