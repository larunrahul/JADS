package com.learning.ads.misc;

public class MatriSpiralOrder<T> {

	public T[] spiral(T[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Object[] spiral = new Object[rows * cols];
		int colStart = 0, rowStart = 0, colEnd = cols - 1, rowEnd = rows - 1;
		int arrIndex = 0;
		while (colStart <= colEnd || rowStart <= rowEnd) {
			if (colStart <= colEnd || rowStart == rowEnd) {
				for (int i = colStart; i <= colEnd; i++) {
					spiral[arrIndex++] = matrix[rowStart][i];
				}
				if (rowStart == rowEnd) {
					break;
				}
			}

			if (rowStart < rowEnd || colStart == colEnd) {
				for (int i = rowStart + 1; i <= rowEnd; i++) {
					spiral[arrIndex++] = matrix[i][colEnd];
				}
				if (colStart == colEnd) {
					break;
				}
			}

			if (colEnd >= colStart) {
				for (int i = colEnd - 1; i >= colStart; i--) {
					spiral[arrIndex++] = matrix[rowEnd][i];
				}
			}
			if (rowEnd > rowStart) {
				for (int i = rowEnd - 1; i > rowStart; i--) {
					spiral[arrIndex++] = matrix[i][colStart];
				}
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
