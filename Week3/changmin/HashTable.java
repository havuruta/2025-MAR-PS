package Week3.changmin;

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
        return Math.abs(key.hashCode()) % capacity;
    }

    void put(K key, V value){
        return;
    };
    V get(K key){
        return null;
    };
    V remove(K key){
        return null;
    };
    boolean containsKey(K key){
        return false;
    };
    int size(){
        return 0;
    };
    boolean isEmpty(){
        return false;
    };
    void clear(){
        return;
    };

}
