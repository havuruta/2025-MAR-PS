package Week3.changmin;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    void push(T value){ // 일반적 O(1), resize()할 경우 O(n)
        if(top + 1 == capacity) { //꽉 찬 경우 사이즈 늘려주기
        	resize();
        }
        
        array[++top] = value; //top을 증가시켜주고 value저장
        
    };
    
    T pop(){ //O(1)
        if(top == -1) { //-1일경우 비어있음
        	throw new NoSuchElementException("Stack이 비어있습니다");
        }
        T value = array[top--];
        
        return value;
    };
    
    T peek(){ //O(1)
    	if(top == -1) { //-1일경우 비어있음
    		throw new NoSuchElementException("Stack이 비어있습니다");
        }
        T value = array[top];
        
        return value;
    };
    
    boolean isEmpty(){ //O(1)
        return top == -1;
    };
    
    int size(){ //O(1)
        return top+1;
    };
    
    void clear(){ //O(1)
    	top = -1;
        return ;
    };

}
