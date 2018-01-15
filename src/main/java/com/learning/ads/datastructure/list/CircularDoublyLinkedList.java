package com.learning.ads.datastructure.list;

import java.util.Stack;

import com.learning.ads.datastructure.exception.UnInitializedException;

/**
 * A generic Circular Doubly Linked List implementation
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class CircularDoublyLinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	private long length;

	public long length() {
		return length;
	}

	private static class Node<T> {
		T value;
		Node<T> next;
		Node<T> prev;

		private Node(T value) {
			this.value = value;
		}

		private Node(Node<T> prev, T value, Node<T> next) {
			this.prev = prev;
			this.value = value;
			this.next = next;
			if (prev != null) {
				prev.next = this;
			}
			if (next != null) {
				next.prev = this;
			}
		}
	}

	/**
	 * Creates a DoublyLinkedList container and pushes the given values into it.
	 * 
	 * @param nodes
	 */
	@SafeVarargs
	public CircularDoublyLinkedList(T... values) {
		for (int index = 0; index < values.length; index++) {
			append(values[index]);
		}
	}

	/**
	 * Appends a new node with given value at the end of the existing list
	 * 
	 * Complexity: O(1)
	 * 
	 * @param value
	 */
	public void append(T value) {
		Node<T> node = new Node<T>(tail, value, head);
		if (length == 0) {
			head = tail = node;
			head.next = tail;
			tail.prev = head;
		} else {
			tail = tail.next;
		}
		length++;
	}

	/**
	 * Prepends a new node with given value at start of the list and makes this new
	 * node as head of list
	 * 
	 * Complexity: O(1)
	 * 
	 * @param value
	 */
	public void prepend(T value) {
		Node<T> node = new Node<T>(tail, value, head);
		if (length == 0) {
			head = tail = node;
			head.next = tail;
			tail.prev = head;
		} else {
			head = node;
		}
		length++;
	}

	/**
	 * Fetches the node at given position. Negative position fetches the node from
	 * end.
	 * 
	 * Complexity: O(n)
	 * 
	 * @param position
	 * @return
	 */
	public T get(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		throwIfOutOfbounds(position);
		return getNode(position).value;
	}

	/**
	 * Inserts a new node at given position. Negative position appends node from end
	 * of list
	 * 
	 * Complexity: O(n)
	 * 
	 * @param value
	 * @param position
	 */
	public void insert(T value, long position) {
		if (position < 0) {
			position = length + position + 1;
		}
		if (position == length) {
			append(value);
			return;
		}
		throwIfOutOfRange(position);
		insertBefore(getNode(position), value);
	}

	/**
	 * Deletes a node at given position. Negative position deletes node from end of
	 * list
	 * 
	 * Complexity: O(n)
	 * 
	 * @param position
	 */
	public void delete(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		throwIfOutOfbounds(position);
		deleteThis(getNode(position));
	}

	/**
	 * Fetches the head node.
	 * 
	 * Complexity: O(1)
	 * 
	 * @return
	 */
	public T getHead() {
		ensureInitialized();
		return head.value;
	}

	/**
	 * Fetches the tail node.
	 * 
	 * Complexity: O(1)
	 * 
	 * @return
	 */
	public T getTail() {
		ensureInitialized();
		return tail.value;
	}

	private void deleteThis(Node<T> node) {
		node.value = null;
		if (head == tail) {
			head = tail = null;
		} else {
			if (node.prev == tail) {
				head = node.next;
			}
			node.prev.next = node.next;
			if (node.next == head) {
				tail = node.prev;
			}
			node.next.prev = node.prev;
		}

		length--;
	}

	private void ensureInitialized() {
		if (head == null || tail == null || length == 0) {
			throw new UnInitializedException("Datastructure is initialized properly");
		}
	}

	private void throwIfOutOfbounds(long position) {
		if (position < 0 || position >= length) {
			throw new IndexOutOfBoundsException(
					"Given position: " + position + " is out of bounds of list length: " + length);
		}
	}

	private void throwIfOutOfRange(long position) {
		if (position < 0 || position > length) {
			throw new IndexOutOfBoundsException(
					"Given position: " + position + " is out of range of list length: " + length);
		}
	}

	private Node<T> getNode(long position) {
		if (position < (length >> 1)) {
			Node<T> current = head;
			long count = 0;
			while (count < position) {
				count++;
				current = current.next;
			}
			return current;
		} else {
			Node<T> current = tail;
			long count = length - 1;
			while (count > position) {
				count--;
				current = current.prev;
			}
			return current;
		}
	}

	private void insertBefore(Node<T> node, T value) {
		Node<T> newNode = new Node<T>(node.prev, value, node);
		if (newNode.prev == tail) {
			head = newNode;
		}
		length++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> current = head;
		while (current != tail) {
			sb.append(current.value).append(",");
			current = current.next;
		}
		if (tail != null) {
			sb.append(tail.value);
		}
		sb.append("]");
		return sb.toString();
	}

	public String prepareBack() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> current = tail;
		while (current != head) {
			sb.append(current.value).append(",");
			current = current.prev;
		}
		if (tail != null) {
			sb.append(head.value);
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Just for internal purpose. This should not be here.
	 */
	void assertCorrectness() {
		if ((head == null && tail != null) || (tail == null && head != null)) {
			throw new RuntimeException("List is not functoning properly");
		} else if ((tail != null && tail.next != head) || (head != null && head.prev != tail)) {
			throw new RuntimeException("List is not circular");
		}
		Stack<CircularDoublyLinkedList.Node<T>> front = new Stack<>();
		Node<T> current = head;
		long fLength = 0;
		while (current != tail) {
			front.push(current);
			fLength++;
			current = current.next;
		}
		front.push(tail);
		fLength++;
		current = tail;
		long rLength = 0;
		while (current != head) {
			if (current != front.pop()) {
				throw new RuntimeException("List is not functoning properly");
			}
			rLength++;
			current = current.prev;
		}
		if (current != front.pop()) {
			throw new RuntimeException("List is not functoning properly");
		}
		rLength++;
		if (fLength != rLength) {
			throw new RuntimeException("List is not functoning properly");
		}
	}
}
