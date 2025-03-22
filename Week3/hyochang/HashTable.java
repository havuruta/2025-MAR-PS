import java.util.NoSuchElementException;

/* 참고 목록
 * https://oneny.tistory.com/31 예시 코드 참고
 * https://nstgic3.tistory.com/entry/해시-충돌과-참조-지역성-자바-HashMap-성능-저하-케이스
 * HashMap.class, String.class.hashCode() 메서드 구성 참고
 * gpt 메서드 구현 및 예외 처리 검토
 * 
 */

 public class HashTable<K, V> {
     public HashTable() {
         @SuppressWarnings("unchecked")
         Node<K, V>[] temp = new Node[DEFAULT_CAPACITY];
         // temp를 사용하여 메서드 내에서 경고 처리를 해당 줄에만 적용 가능
         table = temp;
         size = 0;
         threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
     }
 
     private static class Node<K, V> {
         final K key;
         V value;
         Node<K, V> next;
 
         public Node(K key, V value, Node<K, V> next) {
             this.key = key;
             this.value = value;
             this.next = next;
 
         }
     }
 
     private Node<K, V>[] table;
     private int size;
     // resize() 하는 기준 75% 값이 들어오면 알아서 확장
     private static final float LOAD_FACTOR = 0.75f;
     private static final int DEFAULT_CAPACITY = 16;
     private int threshold;// 현재 수용률
     /*
      * 요구사항 HashTable put(key, value) get(key) remove(key) resize()
      * 
      * 
      * 체이닝 방식 충돌?
      *  - Hash?
      *  haschCode()는 데이터의 해쉬값을 구하는 메서드
      *  StringUTF16.hashCode(value), StringLatin1.hashCode(value)로 연산
      *  - 매우 정교한 설계가 되어있지만 같은 값을 가질 수 있음
      * 
      * 적절한 조치
      * -> 노드 형식으로 연결해놔서 해당 해시코드 값에 있는 노드를 탐색함
      * -> LinkedList 구현할때 했었던
      * 해시코드 -> 테이블의 idx
      * key -> 진짜로 찾아야하는 고유한 키
      * 실제 자바에서는 8개 이상 모이면 Red-Black Tree로 변환
      * (nstgic3.tistory.com 해시충돌에 대해 자세하게 설명해놨음)
      * 
      */
 
     private Node<K, V> getNode(K key) {// O(1) 최악 O(n)
         // HashMap의 getNode 구현
         int hash = key.hashCode();
         int index = Math.abs(hash % table.length); // 음수 방지
 
         Node<K, V> current = table[index];// 현재 노드
         while (current != null) {// 연결된 다음 노드를 부름
             if (current.key.equals(key)) {// 같은 키를 찾으면 종료
                 return current;
             }
             current = current.next;// 다음 노드로 가는
         }
         return null; // 찾지 못한 경우
     }
 
     private void resize() {// O(n) resize 메서드 구현
         // 2배로 확장
         // 기존 해시값을 나누는 것이 달라지니
         // 들어가는 위치가 바뀔 수 있음
         // 기존 테이블에서 꺼내서 다시 넣어줌
         int newSize = table.length * 2;
         @SuppressWarnings("unchecked")
         Node<K, V>[] newTable = (Node<K, V>[]) new Node[newSize];
 
         for (int i = 0; i < table.length; i++) {
             Node<K, V> current = table[i];
 
             while (current != null) {
                 // 새로운 인덱스
                 int newIndex = Math.abs(current.key.hashCode() % newSize);
                 // 연결 작업
                 Node<K, V> nextNode = current.next;
                 // 새로운 인덱스가 들어갈 수 있지만 큰 문제는 없음
                 current.next = newTable[newIndex];
                 newTable[newIndex] = current;
                 current = nextNode;
             }
         }
 
         table = newTable;
         threshold = (int) (newSize * LOAD_FACTOR);
     }
 
     public void put(K k, V v) {// O(1) 최악 O(n)
         Node<K, V> node = getNode(k);
         if (node != null) {// 키가 이미 존재하면 값만 덮어쓰기
             node.value = v;
             return;
         }
 
         int hash = k.hashCode();
         int index = Math.abs(hash % table.length);
         // 새 노드를 체이닝 방식으로 삽입 (맨 앞에 추가)
         Node<K, V> newNode = new Node<>(k, v, table[index]);
         table[index] = newNode;
         size++;
 
         // 넘어가는지 확인
         if (size >= threshold) {
             resize();
         }
     }
 
     public void remove(K k) {// O(1) 최악 O(n)
         int hash = k.hashCode();
         int index = Math.abs(hash % table.length);
 
         Node<K, V> current = table[index];
         Node<K, V> prev = null;
 
         while (current != null) {
             if (current.key.equals(k)) {
                 if (prev == null) {
                     table[index] = current.next;
                 } else {
                     prev.next = current.next;
                 }
                 size--;
                 return;
             }
             prev = current;
             current = current.next;
         }
         // 제거를 못해서 여기까지왔다면
         throw new NoSuchElementException(k + " 가 없음");
     }
 
     public V get(K k) {// O(1) 최악 O(n)
         Node<K, V> result = getNode(k);
         if (result == null) {// 없는 경우
             throw new NoSuchElementException(k + " 가 없음");
         }
         return result.value;
     }
 
     public void clear() {// O(n)
         for (int i = 0; i < table.length; i++) {
             table[i] = null;
         }
         size = 0;
     }
 
     public boolean containsKey(K key) {// O(n)
         return getNode(key) != null;
     }
 
     public boolean containsValue(V value) {// O(n/m) m 테이블 길이 최악 O(n)
         for (int i = 0; i < table.length; i++) {
             Node<K, V> current = table[i];
             
             while (current != null) {
                 if (current.value.equals(value)) {
                     return true;
                 }
                 current = current.next;
             }
             
         }
         return false;
     }
 
     public int size() {// O(1)
         return size;
     }
 
     public boolean isEmpty() {// O(1)
         return size == 0;
     }
 
     @Override
     public String toString() {// O(n)
         StringBuilder sb = new StringBuilder();
         sb.append("[\n");
 
         for (int i = 0; i < table.length; i++) {
 
             if (table[i] != null) {
                 sb.append("  ").append(i).append(": { ");
                 Node<K, V> current = table[i];
                 while (current != null) {
                     sb.append("\"").append(current.key).append("\": ");
                     sb.append("\"").append(current.value).append("\"");
                     current = current.next;
                     if (current != null) {
                         sb.append(", ");
                     }
                 }
                 sb.append(" },\n");
             }
         }
         sb.append("]");
         return sb.toString();
     }
 
 }
 