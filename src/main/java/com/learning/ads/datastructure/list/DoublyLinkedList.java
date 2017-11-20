package com.learning.ads.datastructure.list;

import com.learning.ads.datastructure.exception.UnInitializedException;

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

	@SafeVarargs
	public DoublyLinkedList(T... nodes) {
		if (nodes.length > 0) {
			head = new Node<>(null, nodes[0], null);
			Node<T> current = head;
			length++;
			for (int i = 1; i < nodes.length; i++) {
				current.next = new Node<>(current, nodes[i], null);
				length++;
				current = current.next;
			}
			tail = current;
		}
	}

	public void append(T value) {
		Node<T> node = new Node<T>(tail, value, null);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
		length++;
	}

	public void prepend(T value) {
		Node<T> node = new Node<T>(null, value, head);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
		length++;
	}

	public T get(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		throwIfOutOfbounds(position);
		if (position < (length >> 1)) {
			Node<T> current = head;
			long count = 0;
			while (count < position) {
				count++;
				current = current.next;
			}
			return current.value;
		} else {
			Node<T> current = tail;
			long count = length - 1;
			while (count > position) {
				count--;
				current = current.prev;
			}
			return current.value;
		}
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
		if (position < (length >> 1)) {
			Node<T> current = head;
			long count = 0;
			while (count < position - 1) {
				count++;
				current = current.next;
			}
			Node<T> node = new Node<T>(current, value, current.next);
			current.next.prev = node;
			current.next = node;
		} else {
			Node<T> current = tail;
			long count = length - 1;
			while (count > position) {
				count--;
				current = current.prev;
			}
			Node<T> node = new Node<T>(current.prev, value, current);
			current.prev.next = node;
			current.prev = node;
		}
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
		if(position == length - 1) {
			tail = tail.prev;
			tail.next = null;
			length--;
			return;
		}
		throwIfOutOfbounds(position);
		if (position < (length >> 1)) {
			Node<T> current = head;
			long count = 0;
			while (count < position - 1) {
				count++;
				current = current.next;
			}
			Node<T> node = current.next;
			current.next = node.next;
			current.next.prev = current;
		} else {
			Node<T> current = tail;
			long count = length - 1;
			while (count > position + 1) {
				count--;
				current = current.prev;
			}
			Node<T> node = current.prev;
			current.prev = node.prev;
			current.prev.next = node.next;
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
