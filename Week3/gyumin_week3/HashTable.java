package gyumin_week3;

import gyumin_week3.exceptions.ValueNotFoundException;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<K, V>[] table;
    private int capacity;
    private int size;
    private static final float LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = 16;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        // 키 값을 해시코드로
        // hashCode() 함수는 각 자료형마다 일련의 코드로 변환되는 식이 존재
        return Math.abs(key.hashCode()) % capacity;
    }

    void put(K key, V value) {
        // 일단 배열 복사
        if (size >= capacity * LOAD_FACTOR) {
            capacity *= 2;
            Entry<K, V>[] newTable = new Entry[capacity];
            // 앞에서부터 차곡차곡 들어가는 구조가 아니기에 전체를 봐야
            for (int i = 0; i < table.length; i++) {
                newTable[i] = table[i];
            }

            table = newTable;
        }

        int idx = hash(key);

        // 변환된 인덱스에 이미 값이 있으면?
        if (table[idx] != null) {
            Entry<K, V> temp = table[idx];
            // 그 인덱스에 해당하는 엔트리 리스트의 끝을 찾아야 함
            while (temp.next != null) {
                // 키가 중복되면 값을 덮어써야 함
                if(key.equals(temp.key)){
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            temp.next = new Entry<K, V>(key, value);
            size++;
        }
        // 아니면 그냥 넣으면 됨
        else {
            table[idx] = new Entry<K, V>(key, value);
            size++;
        }
    };

    V get(K key) {
        int idx = hash(key);

        // 테이블에 값이 없음
        if (table[idx] == null) {
            throw new ValueNotFoundException();
        }

        // 값이 있으면 키와 일치하는 지 검사
        Entry<K, V> temp = table[idx];
        boolean isFound = false;

        while (temp != null) {
            if (key.equals(temp.key)) {
                isFound = true;
                break;
            }

            temp = temp.next;
        }

        // 그냥 해쉬 값이 같았고 그 키 값의 정보가 없을 수 있음
        if (!isFound) {
            throw new ValueNotFoundException();
        }

        return temp.value;

    };

    V remove(K key) {
        int idx = hash(key);

        // 테이블에 값이 없음
        if (table[idx] == null) {
            throw new ValueNotFoundException();
        }

        // 값이 있으면 키와 일치하는 지 검사
        Entry<K, V> temp = table[idx];
        Entry<K, V> pre = null;
        boolean isFound = false;

        while (temp != null) {
            if (key.equals(temp.key)) {
                isFound = true;
                break;
            }

            pre = temp;
            temp = temp.next;
        }

        // 그냥 해쉬 값이 같았고 그 키 값의 정보가 없을 수 있음
        if (!isFound) {
            throw new ValueNotFoundException();
        }

        V res = temp.value;

        // 이 경우는 그 자리에 값이 하나만 있는 경우
        if(pre == null){
            table[idx] = null;
        }
        // 이 경우는 값이 둘 이상 있는 경우
        else {
            pre.next = temp.next;
        }
        size--;

        return res;

    };

    boolean containsKey(K key) {
        int idx = hash(key);

        // 테이블에 값이 없음 -> 무조건 없음
        if (table[idx] == null) {
            return false;
        }

        // 값이 있으면 키와 일치하는 지 검사
        Entry<K, V> temp = table[idx];
        boolean isFound = false;

        while (temp != null) {
            if (key.equals(temp.key)) {
                isFound = true;
                break;
            }

            temp = temp.next;
        }

        return isFound;
    };

    int size() {
        return size;
    };

    boolean isEmpty() {
        return size == 0;
    };

    void clear() {
        capacity = 16;
        table = new Entry[capacity];
        size = 0;
    };

}
