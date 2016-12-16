package com.learning.ads.math.numbertheory.prime;

public class SeiveOfEratosthenes {
	
	private int[] array;
	
	public SeiveOfEratosthenes(int limit){
		/*
		 * 
		 */
		array = new int[limit-1];
		for(int value = 2, index = 0; value <= limit; value++,index++){
			array[index] = value;
		}
	}
	
	public void printPrimes(){
		for(int index = 0;index < array.length; index++){
			int next = index+1;
			if(array[index] != 0){
				System.out.print(array[index]+"\t");
				while(next < array.length){
					if(array[next] != 0 && array[next] % array[index] == 0){
						array[next] = 0;
					}
					next += 1;
				}
			}
		}
	}
	
	private void printArray(){
		for(int i : array){
			System.out.print(i+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SeiveOfEratosthenes soe = new SeiveOfEratosthenes(100);
		soe.printArray();
		soe.printPrimes();

	}

}
