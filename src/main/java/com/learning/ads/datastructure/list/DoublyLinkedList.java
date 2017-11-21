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
		if (length == 0) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
		length++;
	}

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

	public T get(long position) {
		ensureInitialized();
		if (position < 0) {
			position = length + position;
		}
		throwIfOutOfbounds(position);
		return getNode(position).value;
	}

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

	public String printBack() {
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
