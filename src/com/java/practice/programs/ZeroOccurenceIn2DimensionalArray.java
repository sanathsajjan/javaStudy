package com.java.practice.programs;

public class ZeroOccurenceIn2DimensionalArray {

	public static void main(String[] args) {
		int[][] array = {
				{1, 1, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{0, 1, 1, 1, 1},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 0, 1}
		};
		System.out.println("rowLength:" + array.length);
		int rowLength = array.length;
		int columnWidth = array[0].length;

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnWidth; j++) {
				if (array[i][j] == 0) {
					System.out.println(i + "," + j);
				}
			}
		}

		/*
		 * for(int i=0, j=0; i<rowLength, j<columnWidth; i++, ) {
		 * 
		 * }
		 */



	}
}
