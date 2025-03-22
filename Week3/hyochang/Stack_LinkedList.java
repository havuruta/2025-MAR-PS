import java.util.EmptyStackException;

public class Stack_LinkedList<T> {
	private Node<T> top;
	private int size;

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	public Stack_LinkedList() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T push(T value) {
		Node<T> newNode = new Node<>(value);
		newNode.next = top;
		top = newNode;
		size++;
		return value;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T result = top.data;
		top = top.next;
		size--;
		return result;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public int size() {
		return size;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Node<T> current = top;
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
