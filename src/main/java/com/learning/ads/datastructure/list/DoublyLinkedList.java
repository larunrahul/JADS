package com.learning.ads.datastructure.list;

import com.learning.ads.datastructure.exception.UnInitializedException;

/**
 * A generic Doubly Linked List implementation
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {

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
		}
	}

	/**
	 * Creates a DoublyLinkedList container and pushes the given values into it.
	 * 
	 * @param nodes
	 */
	@SafeVarargs
	public DoublyLinkedList(T... values) {
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
		Node<T> node = new Node<T>(tail, value, null);
		if (length == 0) {
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
		Node<T> node = new Node<T>(null, value, head);
		if (length == 0) {
			head = tail = node;
		} else {
			node.next = head;
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

	private void deleteThis(Node<T> node) {
		node.value = null;
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next == null) {
			tail = node.prev;
		} else {
			node.next.prev = node.prev;
		}
		length--;
	}

	private void ensureInitialized() {
		if (head == null || tail == null) {
			throw new UnInitializedException("Datastructure not initialized properly");
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
		if (newNode.prev == null) {
			head = newNode;
		} else {
			newNode.prev.next = newNode;
		}
		node.prev = newNode;
		length++;
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

	public String prepareBack() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> current = tail;
		while (current != null) {
			sb.append(current.value).append(",");
			current = current.prev;
		}
		sb.append("]");
		if (sb.length() == 2) {
			return sb.toString();
		}
		return sb.toString().substring(0, sb.length() - 2) + sb.toString().substring(sb.length() - 1, sb.length());
	}

}
