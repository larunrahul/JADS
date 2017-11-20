package com.learning.ads.datastructure.list;

import com.learning.ads.datastructure.exception.UnInitializedException;

public class LinkedList<T> {

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
	public LinkedList(T... nodes) {
		if (nodes.length > 0) {
			head = new Node<>(nodes[0]);
			length++;
			Node<T> current = head;
			for (int i = 1; i < nodes.length; i++) {
				current.next = new Node<>(nodes[i]);
				length++;
				current = current.next;
			}
			tail = current;
		}
	}

	public long length() {
		return length;
	}

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

	public void insert(T value, long position) {
		if (position < 0) {
			position = length + position + 1;
		}
		if (position == 0) {
			prepend(value);
			return;
		}
		if (position == length) {
			append(value);
			return;
		}
		throwIfOutOfbounds(position);
		Node<T> current = head;
		long count = 0;
		while (count < position - 1) {
			count++;
			current = current.next;
		}
		Node<T> node = new Node<T>(value);
		node.next = current.next;
		current.next = node;
		length++;
	}

	public void delete(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		if (position == 0) {
			head = head.next;
			length--;
			return;
		}
		throwIfOutOfbounds(position);
		Node<T> current = head;
		long count = 0;
		while (count < position - 1) {
			count++;
			current = current.next;
		}
		Node<T> node = current.next;
		current.next = node.next;
		length--;
		return;
	}

	public T get(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		throwIfOutOfbounds(position);
		Node<T> current = head;
		long count = 0;
		while (count < position) {
			count++;
			current = current.next;
		}
		return current.value;
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

}
