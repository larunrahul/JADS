package com.learning.ads.datastructure.list;

import com.learning.ads.datastructure.exception.UnInitializedException;

/**
 * A genetic implementation of Circular Linked List
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class CircularLinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	private long length;

	private static class Node<T> {
		T value;

		Node<T> next;

		private Node(T value) {
			this.value = value;
		}
	}

	@SafeVarargs
	public CircularLinkedList(T... values) {
		for (int index = 0; index < values.length; index++) {
			append(values[index]);
		}
	}

	public long length() {
		return length;
	}

	public void append(T value) {
		Node<T> node = new Node<>(value);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
		tail.next = head;
		length++;
	}

	public void prepend(T value) {
		Node<T> node = new Node<T>(value);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
		tail.next = head;
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
			if (length == 1) {
				head = tail = null;
			} else {
				head = head.next;
				tail.next = head;
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

	public void assertCorrectness() {
		if (head == null) {
			if (tail != null) {
				throw new RuntimeException("List is not functoning properly");
			}
		} else {
			if (tail.next != head) {
				throw new RuntimeException("List is not functoning properly");
			}
		}
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
			throw new UnInitializedException("Datastructure not initialized properly");
		}
	}

	private void throwIfOutOfbounds(long position) {
		if (position < 0 || position >= length) {
			throw new IndexOutOfBoundsException(
					"Given position: " + position + " is out of bounds of list length: " + length);
		}
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

}
