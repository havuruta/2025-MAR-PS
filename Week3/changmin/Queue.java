package Week3.changmin;

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

    void enqueue(T value){ //O(1), resize시 O(n)
        if(size == capacity) {
        	resize();
        }
        
        array[rear] = value; //rear에 저장
        rear = next(rear); //다음 rear설정
        size++; //크기 ++
    };
    
    T dequeue(){ //O(1)
        if(isEmpty()) { //비었을 경우
        	throw new IllegalStateException("Queue가 비었습니다");
        }
        
        T value = array[front]; //front 에 있는 값 저장
        //여기에서 front 자리를 null로 바꿔도 괜찮음
        //GPT : 꼭 필요한 건 아니지만, 대용량 객체 큐에서는 메모리 관리상 도움이 돼 라고 합니다
        front = next(front); //front 변경
        size--; //사이즈 줄임
        return value;
    };
    
    T peek(){ //O(1)
    	if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return array[front];
    };
    
    boolean isEmpty(){ //O(1)
    	return size == 0;
    };
    
    int size(){ //O(1)
        return size;
    };
    
    void clear(){ //O(1)
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    };

}
