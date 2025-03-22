
import java.util.EmptyStackException;

/* 참고 목록
 * https://growupdevmind.tistory.com/43 예시 코드 참고
 * stack.class, Vector.class 메서드 구성 참고
 * gpt 메서드 구현 및 예외 처리 검토
 * 
 */

public class Stack<T> {
    private Object[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;
    // 사이즈에 대한 변수가 지정되어 있음 용량이 차게 된다면 resize()
    // vector에 가서 보면 elementCount 라는 변수로 관리함
    // 기본 생성은 10이니까

    public Stack() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    /*
     * 요구사항 Stack(배열 기반) push(value) pop() peek() isEmpty() resize()
     * 
     * 단순하게 넣고 size 증가 꺼내는건 size 함수 이용 resize는 배열이 꽉 차게 되었을 때 확장하는 매서드
     * resize와 isEmpty 먼저 구현
     * 
     * synchronized? 한 번에 하나의 스레드만 접근하도록 제한 멀티 스레드 환경에서 동시 접근으로 인한 데이터 손상 및 충돌 방지
     * 하나의 쓰레드만 접근하게 하여 안정성, 일관성 보장 -> 현재는 필요없음
     */

    // vector의 grow기능
    // 추가 시 size가 data.length와 같으면 실행
    // 2배로 늘리고 깊은 복사
    // O(n) 이지만 자주일어나지 않아서 amortized O(1)
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean isEmpty() {// O(1)
        return size == 0;
    }

    public T push(T value) {// O(1)
        // 값을 넣는 메서드로만 알았음
        // stack에서는 반환하게 설정해놓음
        if (size == data.length) {// 발생시 O(n)
            resize();
        }
        data[size++] = value;
        return value;
    }

    public T pop() {// O(1)
        if (isEmpty()) {
            // 예외는 유지 보수 측면에서는 기본 예외를 사용하는 것이 좋음
            // 비어있으면 예외처리
            // throw new RuntimeException("스택 비었음");
            // java 기본 예외
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        T result = (T) data[size - 1];
        // SuppressWarnings -> 형변환 시 타입 안정성에 대한 경고 발생
        // 컴파일러에게 이 형변환을 인지하고 무시하도록 지시

        // 왜 캐스팅, 어노테이션 필요?
        // 제네릭은 컴파일 시에만 타입의 정보를 유지
        // 이후에는 object 배열로 만들기 때문에 캐스팅이 필요
        // T[] array = (T[]) new Object[10]; 형식으로 생성 가능
        // 그래도 @도 항상 작성해야하고, 캐스팅도 해주어야함(불편)

        data[size - 1] = null;
        size--;
        return result;
    }

    public T peek() { // O(1)
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        T result = (T) data[size - 1];
        return result;
    }

    public int size() {// O(1)
        return size;
    }

    public void clear() {// O(n)
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {// O(n)
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append(">");
        return sb.toString();
    }

}
