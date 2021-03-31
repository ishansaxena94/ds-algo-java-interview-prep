package matrix;

public class SpiralMatrx {

	static void printSpiral(int mat[][]) {

		int topRow = 0, endRow = mat.length - 1;
		int leftCol = 0, rightCol = mat[0].length - 1;
		int i;

		while (topRow <= endRow && leftCol <= rightCol) {

			// print top row : Left to Right
			for (i = leftCol; i <= rightCol; i++)
				System.out.print(mat[topRow][i] + " ");
			topRow++;

			// print right column
			for (i = topRow; i <= endRow; i++)
				System.out.println(mat[i][rightCol] + " ");
			rightCol--;

			// print bottom column
			if (endRow >= topRow) {
				for (i = rightCol; i >= leftCol; i--)
					System.out.print(mat[endRow][i] + " ");
				endRow--;
			}

			// print left column : bottom to top
			if (leftCol <= rightCol) {
				for (i = endRow; i >= topRow; i--)
					System.out.println(mat[i][leftCol] + " ");

			}
		}

	}

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		printSpiral(a);
	}

}
