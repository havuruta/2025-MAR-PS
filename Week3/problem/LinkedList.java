package Week3.problem;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    void add(T value){};
    void add(int index, T value){};
    T get(int index){
        return null;
    };
    T remove(int index){
        return null;
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
    int indexOf(T value){
        return 0;
    };
    boolean contains(T value){
        return false;
    };

}