package com.learning.ads.sort.quick;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.learning.ads.sort.quick.partition.HoarePartition;
import com.learning.ads.sort.quick.partition.LomutoPartition;
import com.learning.ads.sort.quick.partition.MixHoarePartition;
import com.learning.ads.sort.quick.partition.Partition;
import com.learning.ads.sort.quick.partition.RandomLomutoPartition;

public class QuickSortTest {

	Partition<Integer> lomutoPartition = new LomutoPartition<>();
	Partition<Integer> randomLomutoPartition = new RandomLomutoPartition<>();
	Partition<Integer> hoarePartition = new HoarePartition<>();
	Partition<Integer> mixHoarePartition = new MixHoarePartition<>();

	@Test
	public void sortAscendingLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingAlreadySortdLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingReverseSortdLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 7, 6, 5, 4, 3, 2, 1 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingRandomizedLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(randomLomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new HoareQSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
		array = new Integer[]{6,5,6,2,4,1,1,2};
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1,1,2,2,4,5,6,6 }, array);
	}

	@Test
	public void sortAscendingSemiSortedHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new HoareQSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 1, 2, 3, 4, 5, 6, 7 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingMixHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(mixHoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortAscendingMixHoarePartitionDuplicatElements() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(mixHoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 8 }, array);
	}

	@Test
	public void sortAscendingQuickSortWithInsertionSort() {
		QSort<Integer, Partition<Integer>> qSort = new QuickSortWithInsertionSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 1, 2, 3, 4, 5, 6, 7, 9, 14, 13, 10, 17, 12, 20, 19 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 17, 19, 20 }, array);
	}

	@Test
	public void sortAscendingLomutoQuickSortWithEqualElements() {
		QSort<Integer, Partition<Integer>> qSort = new LomutoQSortWithEqualElements<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 8 }, array);
		array = new Integer[] { 8, 1, 2, 3, 4, 5, 6, 7, 9, 14, 13, 10, 17, 12, 20, 19 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 17, 19, 20 }, array);
	}

	@Test
	public void sortAscendingPartitionWithEqualElementsDNF() {
		QSort<Integer, Partition<Integer>> qSort = new PartitionWithEqualElementsDNF<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 8 }, array);
		array = new Integer[] { 8, 1, 2, 3, 4, 5, 6, 7, 9, 14, 13, 10, 17, 12, 20, 19 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 17, 19, 20 }, array);
	}

	@Test
	public void sortDescendingQuickSortWithInsertionSort() {
		QSort<Integer, Partition<Integer>> qSort = new QuickSortWithInsertionSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 1, 2, 3, 4, 5, 6, 7, 9, 14, 13, 10, 17, 12, 20, 19 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 20, 19, 17, 14, 13, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingAlreadySortedLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 7, 6, 5, 4, 3, 2, 1 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingReverseSortedLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingRandomLomutoPartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(randomLomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new HoareQSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingMixHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new QSort<>(mixHoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingSemiSortedHoarePartition() {
		QSort<Integer, Partition<Integer>> qSort = new HoareQSort<>(hoarePartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 8, 1, 2, 3, 4, 5, 6, 7 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingLomutoQuickSortWithEqualElements() {
		QSort<Integer, Partition<Integer>> qSort = new LomutoQSortWithEqualElements<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 4, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1 }, array);
		array = new Integer[] { 8, 1, 2, 3, 4, 5, 6, 7 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortDescendingPartitionWithEqualElementsDNF() {
		QSort<Integer, Partition<Integer>> qSort = new PartitionWithEqualElementsDNF<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 4, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1 }, array);
		array = new Integer[] { 8, 1, 2, 3, 4, 5, 6, 7, 9, 14, 13, 10, 17, 12, 20, 19 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 20, 19, 17, 14, 13, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}

	@Test
	public void sortAscendingBentleyMcllory() {
		QSort<Integer, Partition<Integer>> qSort = new BentleyMcIloryQSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 4, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 }, array);
		array = new Integer[] { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

	@Test
	public void sortDescendingBentleyMcllory() {
		QSort<Integer, Partition<Integer>> qSort = new BentleyMcIloryQSort<>(lomutoPartition);
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(qSort);
		Integer[] array = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 4, 2, 2, 2, 2, 4, 1, 4, 4, 4, 8 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1 }, array);
		array = new Integer[] { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sortDescending(array);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, array);
	}
}
