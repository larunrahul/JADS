package com.learning.ads.datastructure.stack;

/**
 * Stack implementation backed by Dynamic array
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class Stack<T> {

	private Object[] array;

	private int length;

	@SafeVarargs
	public Stack(T... array) {
		if (array.length == 0) {
			this.array = new Object[1];
		} else {
			this.array = array;
			length = array.length;
		}
	}

	public int length() {
		return length;
	}

	public void push(T element) {
		if (isFull()) {
			expand();
		}
		array[length++] = element;
	}
 
	public T pop() {
		throwIfEmpty();
		T last = peek();
		array[--length] = null;
		return last;
	}

	public T peek() {
		throwIfEmpty();
		return dataAt(length - 1);
	}
	
	public boolean isFull() {
		return length == array.length;
	}

	@SuppressWarnings("unchecked")
	private T dataAt(int index) {
		return (T) array[length - 1];
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
		System.arraycopy(this.array, 0, array, 0, length);
		this.array = array;
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
