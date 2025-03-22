package gyumin_week3;

import java.util.Arrays;

import gyumin_week3.exceptions.OutOfBoundException;
import gyumin_week3.exceptions.UnderflowException;

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

        if(top == capacity - 1){
            resize();
        }

        array[++top] = value;

    };
    T pop(){
        if(isEmpty()){
            throw new UnderflowException();
        }

        T temp = array[top--];

        return temp;
    };
    T peek(){
        if(isEmpty()){
            throw new OutOfBoundException();
        }
        return array[top];
    };
    boolean isEmpty(){
        return top == -1;
    };
    int size(){
        return top + 1;
    };
    void clear(){
        capacity = 10;
        array = (T[]) new Object [capacity];
        top = -1;
    };

}
