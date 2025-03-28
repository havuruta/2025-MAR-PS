public class LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("인덱스 초과");

        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("인덱스 초과");
        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            head = newNode;
            if (size == 0)
                tail = newNode;
        } else if (index == size) {
            add(value);
            return;
        } else {
            Node<T> nextNode = getNode(index);
            Node<T> prevNode = nextNode.prev;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("인덱스 초과");

        Node<T> target = getNode(index);
        Node<T> prevNode = target.prev;
        Node<T> nextNode = target.next;

        if (prevNode != null)
            prevNode.next = nextNode;
        else
            head = nextNode;

        if (nextNode != null)
            nextNode.prev = prevNode;
        else
            tail = prevNode;

        size--;
    }

    public void set(int index, T value) {
        getNode(index).data = value;
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((value == null && current.data == null) || (value != null && value.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(", ");
            current = current.next;
        }
        sb.append(">");
        return sb.toString();
    }
}
