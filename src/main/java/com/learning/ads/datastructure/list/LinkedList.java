package com.learning.ads.datastructure.list;

import com.learning.ads.datastructure.exception.UnInitializedException;

/**
 * A generic Linked List implementation
 * 
 * @author Arun Rahul
 *
 * @param <T>
 *            Type of values to be stored in LinkedList
 */

public class LinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	private int length;

	private static class Node<T> {
		T value;

		Node<T> next;

		private Node(T value) {
			this.value = value;
		}
	}

	/**
	 * Creates a LinkedList container and pushes the given values into it.
	 * 
	 * @param nodes
	 */
	@SafeVarargs
	public LinkedList(T... values) {
		for (int index = 0; index < values.length; index++) {
			append(values[index]);
		}
	}

	public long length() {
		return length;
	}

	/**
	 * Appends a new node with given value at the end of the existing list
	 * 
	 * Complexity: O(1)
	 * 
	 * @param value
	 */
	public void append(T value) {
		Node<T> node = new Node<T>(value);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
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
		Node<T> node = new Node<T>(value);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
		length++;
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
		if (position == 0) {
			prepend(value);
		} else if (position == length) {
			append(value);
		} else {
			Node<T> current = getNode(position - 1);
			Node<T> node = new Node<T>(value);
			node.next = current.next;
			current.next = node;
			length++;
		}
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
		if (position == 0) {
			head = head.next;
			if (length == 1) {
				tail = head;
			}
		} else {
			Node<T> current = getNode(position - 1);
			Node<T> node = current.next;
			current.next = node.next;
			if (node == tail) {
				tail = current;
			}
		}
		length--;
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
		Node<T> current = getNode(position);
		return current.value;
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

	private Node<T> getNode(long position) {
		throwIfOutOfbounds(position);
		Node<T> current = head;
		long count = 0;
		while (count < position) {
			count++;
			current = current.next;
		}
		return current;
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

	public T[] toArray() {
		Object[] array = new Object[length];
		Node<T> current = head;
		int i = 0;
		while (current != null) {
			array[i++] = current.value;
			current = current.next;
		}
		return cast(array);
	}

	@SuppressWarnings("unchecked")
	private T[] cast(Object[] array) {
		return (T[]) array;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> current = head;
		while (current != null) {
			sb.append(current.value).append(",");
			current = current.next;
		}
		sb.append("]");
		if (sb.length() == 2) {
			return sb.toString();
		}
		return sb.toString().substring(0, sb.length() - 2) + sb.toString().substring(sb.length() - 1, sb.length());
	}

	/**
	 * Just for internal purpose. This should not be here.
	 */
	void assertCorrectness() {
		if ((head == null && tail != null) || (tail == null && head != null)) {
			throw new RuntimeException("List is not functoning properly");
		}
	}
}
