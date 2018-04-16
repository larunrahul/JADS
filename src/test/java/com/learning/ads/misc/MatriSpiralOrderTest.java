package com.learning.ads.misc;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MatriSpiralOrderTest {

	MatriSpiralOrder<Integer> mso = new MatriSpiralOrder<>();

	@Test
	public void spiralRowVector() {
		assertArrayEquals(new Integer[] { 1 }, mso.spiral(new Integer[][] { { 1 } }));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, mso.spiral(new Integer[][] { { 1, 2, 3, 4 } }));
	}

	@Test
	public void spiralColumnVector() {
		assertArrayEquals(new Integer[] { 1 }, mso.spiral(new Integer[][] { { 1 } }));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, mso.spiral(new Integer[][] { { 1 }, { 2 }, { 3 }, { 4 } }));
	}

	@Test
	public void spiralSquareMatrix() {
		assertArrayEquals(new Integer[] { 1, 2, 4, 3 }, mso.spiral(new Integer[][] { { 1, 2 }, { 3, 4 } }));
		assertArrayEquals(new Integer[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 },
				mso.spiral(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 },
				mso.spiral(new Integer[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));
	}

	@Test
	public void spiralNonSquareNoRowVectorNonColumnVectorMatrix() {
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 },
				mso.spiral(new Integer[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
		assertArrayEquals(new Integer[] { 1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8 },
				mso.spiral(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } }));
		assertArrayEquals(
				new Integer[] { 1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23,
						22, 21, 20, 14, 15, 16 },
				mso.spiral(new Integer[][] { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
						{ 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 } }));
		assertArrayEquals(
				new Integer[] { 1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 29, 28, 27, 26, 21, 16, 11, 6, 7, 8, 9, 14, 19, 24,
						23, 22, 17, 12, 13, 18 },
				mso.spiral(new Integer[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
						{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 }, { 26, 27, 28, 29, 30 } }));
	}

}
