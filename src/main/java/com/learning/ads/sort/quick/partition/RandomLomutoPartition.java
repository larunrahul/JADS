package com.learning.ads.sort.quick.partition;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLomutoPartition<T extends Comparable<T>> implements Partition<T> {

	@Override
	public int part(T[] array, int start, int end) {
		int random = ThreadLocalRandom.current().nextInt(start, end + 1);
		swap(array, random, end);
		T pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	@Override
	public int partDescending(T[] array, int start, int end) {
		int random = ThreadLocalRandom.current().nextInt(start, end + 1);
		swap(array, random, end);
		T pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot) >= 0) {
				i += 1;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

}
