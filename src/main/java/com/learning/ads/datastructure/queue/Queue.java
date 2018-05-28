package com.learning.ads.datastructure.queue;

/**
 * A basic queue implementation backed by dynamic circular array
 * 
 * @author Arun Rahul
 *
 */
public class Queue<T> {

	private Object[] array;

	private int length;

	private int tail;

	private int head;

	@SafeVarargs
	public Queue(T... array) {
		if (array.length == 0) {
			this.array = new Object[1];
		} else {
			for (int i = 0; i < array.length / 2; i++) {
				T temp = array[i];
				array[i] = array[array.length - i - 1];
				array[array.length - i - 1] = temp;
			}
			length = array.length;
			this.array = array;
			head = 0;
			tail = array.length - 1;
		}
	}

	public int length() {
		return length;
	}

	public void enQueue(T element) {
		if (isFull()) {
			expand();
		}
		tail = (tail + 1) % array.length;
		array[tail] = element;
		length++;
	}

	public T deQueue() {
		throwIfEmpty();
		T ret = extracted();
		array[head] = null;
		head = (head + 1) % array.length;
		length--;
		return ret;
	}

	@SuppressWarnings("unchecked")
	private T extracted() {
		return (T) array[head];
	}

	public T tail() {
		throwIfEmpty();
		return dataAt(tail);
	}

	public T head() {
		throwIfEmpty();
		return dataAt(head);
	}

	public boolean isFull() {
		return length == array.length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	@SuppressWarnings("unchecked")
	private T dataAt(int index) {
		return (T) array[index];
	}

	private void throwIfEmpty() {
		if (length == 0) {
			throw new RuntimeException("Stack empty");
		}
	}

	/**
	 * Dynamic array. Each time when array is full, a new array of double the size
	 * is created and old array is copied to new array
	 */
	private void expand() {
		Object[] array = new Object[2 * this.array.length];
		System.arraycopy(this.array, head, array, 0, length - head);
		System.arraycopy(this.array, 0, array, length - head, head);
		this.array = array;
		head = 0;
		tail = length - 1;
	}

	public T[] toArray() {
		Object[] array = new Object[length];
		System.arraycopy(this.array, head, array, 0, length - head);
		System.arraycopy(this.array, 0, array, length - head, head);
		return extracted(array);
	}

	@SuppressWarnings("unchecked")
	private T[] extracted(Object[] array) {
		return (T[]) array;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = length - 1; i >= 0; i--) {
			sb.append(array[i]).append(",");
		}
		sb.append("]");
		if (sb.length() == 2) {
			return sb.toString();
		}
		return sb.toString().substring(0, sb.length() - 2) + sb.toString().substring(sb.length() - 1, sb.length());
	}

}
