package math.numbertheory.prime;

public class SeiveOfEratosthenes {

	private int[] array;

	public SeiveOfEratosthenes(int limit) {

		// Excluding 0 and 1, we populate the array as 2,3,4,.......limit-1,limit.
		// Hence we need limit-2(0,1)+1(last element) = limit-1.
		// For example if our limit is 100(including), then we need 100-2+1 = 99 elements in array.
		array = new int[limit - 1];
		for (int value = 2, index = 0; value <= limit; value++, index++) {
			array[index] = value;
		}
	}

	/**
	 * look at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 */
	public void printPrimes() {
		for (int index = 0; index < array.length; index++) {
			int next = index + 1;
			if (array[index] != 0) {
				System.out.print(array[index] + "\t");
				while (next < array.length) {
					if (array[next] != 0 && array[next] % array[index] == 0) {
						// as removing element from array is too costly, we are just marking it zero
						array[next] = 0;
					}
					next += 1;
				}
			}
		}
	}

	private void printArray() {
		for (int i : array) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SeiveOfEratosthenes soe = new SeiveOfEratosthenes(10000);
		soe.printArray();
		soe.printPrimes();
	}

}
