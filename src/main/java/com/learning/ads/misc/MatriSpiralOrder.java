package com.learning.ads.misc;

/**
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class MatriSpiralOrder<T> {

	/**
	 * Complexity: O(m*n) for matrix of m rows and n columns
	 * 
	 * @param matrix
	 * @return
	 */
	public T[] spiral(T[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Object[] spiral = new Object[rows * cols];
		int colStart = 0, rowStart = 0, colEnd = cols - 1, rowEnd = rows - 1;
		int arrIndex = 0;
		while (colStart <= colEnd || rowStart <= rowEnd) {

			// if any of rows or columns cross each other
			if (colStart > colEnd || rowStart > rowEnd) {
				break;
			}

			// first row
			for (int i = colStart; i <= colEnd; i++) {
				spiral[arrIndex++] = matrix[rowStart][i];
			}

			if (rowStart == rowEnd) {
				break;
			}

			// last column
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				spiral[arrIndex++] = matrix[i][colEnd];
			}
			if (colStart == colEnd) {
				break;
			}

			// last row
			for (int i = colEnd - 1; i >= colStart; i--) {
				spiral[arrIndex++] = matrix[rowEnd][i];
			}

			// first column
			for (int i = rowEnd - 1; i > rowStart; i--) {
				spiral[arrIndex++] = matrix[i][colStart];
			}

			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}
		return extracted(spiral);
	}

	@SuppressWarnings("unchecked")
	private T[] extracted(Object[] spiral) {
		return (T[]) spiral;
	}

}
